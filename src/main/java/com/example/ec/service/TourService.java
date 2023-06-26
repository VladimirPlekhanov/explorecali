package com.example.ec.service;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;
import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;
import com.example.ec.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Tour Package Service
 */
@Service
public class TourService {

    TourRepository tourRepository;
    TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new Tour Object and persist it to the Database
     *
     * @param title title of tour
     * @param description description of tour
     * @param blurb blurb of tour
     * @param price price of tour
     * @param duration duration of tour
     * @param bullets bullets of tour
     * @param keywords keywords of tour
     * @param tourPackageName tourPackageName of tour
     * @param difficulty difficulty of tour
     * @param region region of tour
     * @return Tour entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price, String duration,
        String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
            .orElseThrow(() -> new RuntimeException("Tour package does not exist: " + tourPackageName));
        return tourRepository.save(
            new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    /**
     * Calculate the number of tours in the Database
     * @return the total
     */
    public long total() {
        return tourRepository.count();
    }
}
