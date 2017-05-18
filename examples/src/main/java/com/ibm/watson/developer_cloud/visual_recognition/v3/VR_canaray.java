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
	  
	  
	String myFilePath = "C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/TEST-zip/";
	String classifierID ="Canaray_1432151802";
    
	VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
    service.setApiKey("caa6385d06cc80c1e01694a8a1e85342383a1cc0");
    
    

    /* Make your own Classifier */
/*    System.out.println("Create a Canaray classifier with positive and negative images");
    ClassifierOptions createCanaryOptions = new ClassifierOptions.Builder().classifierName("Canaray")
    		// className , File mandatory parameters
    		.addClass("Calcified Stylohyoid ligaments", new File(myFilePath + "T_calcified_stylohyoid_ligaments.zip"))
    		.addClass("Pneumatocyst", new File(myFilePath +"T_pneumatocyst.zip"))
    		.addClass("Tonsilloliths", new File(myFilePath +"T_tonsilloliths.zip")).build();
    
     you can add negative zip by using ".negativeExamples(new File(myFilePath +"cats.zip")).build()" 
    VisualClassifier result = service.createClassifier(createCanaryOptions).execute();
    System.out.println(result);
*/    
    
    
    System.out.println("Classify using the new classifier which you have created 'Canaray' classifier");
    ClassifyImagesOptions option_classify = new ClassifyImagesOptions.Builder().images(new File(myFilePath +"demo.png"))
        .classifierIds(classifierID).build();
    VisualClassification option_result = service.classify(option_classify).execute();
    System.out.println(option_result);
   
    
    
    
    
    /* Choose your Image */
/*	  System.out.println("Classify an image");
	  ClassifyImagesOptions options = new ClassifyImagesOptions.Builder()
	  	    .images(new File(myFilePath + "demo.png"))
	  	    .build();
	  VisualClassification result = service.classify(options).execute();
	  System.out.println(result);
    */
    
  
    
    
    /* Make your own Classifier , Web reference --> http://visual-recognition-tooling.mybluemix.net/" */
/*	    System.out.println("Create a classifier with positive and negative images");
	    ClassifierOptions createCanaryOptions = new ClassifierOptions.Builder().classifierName("Canaray")
	    		// className , File mandatory parameters
	    		.addClass("husky", new File(myFilePath + "husky.zip"))
	    		.addClass("goldenretriever", new File(myFilePath +"golden-retriever.zip"))
	    		.negativeExamples(new File(myFilePath +"cats.zip")).build();
	    VisualClassifier result = service.createClassifier(createCanaryOptions).execute();
	    System.out.println(result);
   */
	    
	    
    
    /*System.out.println("Classify using the 'Dog Breed' classifier");
    ClassifyImagesOptions option_classify = new ClassifyImagesOptions.Builder().images(new File(myFilePath +"image001.intracranial.png"))
        .classifierIds("classifierID").build();
    VisualClassification option_result = service.classify(option_classify).execute();
    System.out.println(option_result);
    */
    
    
    
   /* System.out.println("Update a classifier with more positive images");
    ClassifierOptions updateOptions = new ClassifierOptions.Builder()
        .addClass("Intracranial", new File("C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/intracranial_calcification.zip")).build();
    VisualClassifier updatedIntracranial = service.updateClassifier(Intracranial.getId(), updateOptions).execute();
    System.out.println(updatedIntracranial);*/

  }
}
