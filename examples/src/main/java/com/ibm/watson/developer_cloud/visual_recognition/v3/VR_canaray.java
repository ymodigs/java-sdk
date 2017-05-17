/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 */
package com.ibm.watson.developer_cloud.visual_recognition.v3;

import java.io.File;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

public class VR_canaray {

  public static void main(String[] args) {
    VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
    service.setApiKey("caa6385d06cc80c1e01694a8a1e85342383a1cc0");

    System.out.println("Classify an image");
    
    ClassifyImagesOptions option_classify = 
    		new ClassifyImagesOptions.Builder().images(new File("C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/image001.intracranial.png")).build();
    VisualClassification option_result = service.classify(option_classify).execute();
    System.out.println(option_result);
    
    System.out.println("Create a classifier with positive and negative images");
    ClassifierOptions createCanaryOptions = new ClassifierOptions.Builder().classifierName("Intracranial")
    		// className , File mandatory parameters
    		.addClass("Intracranial", new File("C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/intracranial_calcification.zip"))
    		.addClass("another", new File("C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/pneumatocyst.zip"))
    		.negativeExamples(new File("C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/calcified_stylohyoid_ligaments.zip")).build();
    VisualClassifier Intracranial = service.createClassifier(createCanaryOptions).execute();
    System.out.println("Intracranial");
    
    System.out.println("Classify using the 'Intracranial' classifier");
    option_classify = new ClassifyImagesOptions.Builder().images(new File("C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/image001.intracranial.png"))
        .classifierIds("Intracranial").build();
    option_result = service.classify(option_classify).execute();
    System.out.println(option_result);
    
    System.out.println("Update a classifier with more positive images");
    ClassifierOptions updateOptions = new ClassifierOptions.Builder()
        .addClass("Intracranial", new File("C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/intracranial_calcification.zip")).build();
    VisualClassifier updatedIntracranial = service.updateClassifier(Intracranial.getId(), updateOptions).execute();
    System.out.println(updatedIntracranial);

  }
}
