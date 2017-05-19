/**
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 */
package com.ibm.watson.developer_cloud.visual_recognition.v3;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifierOptions.Builder;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassifier;

public class VR_canaray {
	
	public static String myFilePath = "C:/Users/specsy/Documents/GitHub/WatsonAPI/java-sdk/visual-recognition/src/test/resources/Test/TEST-zip/";
	public static String classifierID = null;
	
	static VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
	public static VisualClassifier result = null;
	
	static void createCustomClassifier() throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the path:");
		String path = br.readLine();
		File f = new File(path);
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

		List<File> allZipPath = new ArrayList<File>();

		for(int i=0; i<files.size();i++)
		{
			
		  if(files.get(i).getPath().endsWith(".zip"))
		  {  
		    System.out.println("Files are " + files.get(i));

		    allZipPath.add(new File(files.get(i).toString()));

		  }

		}
		
		System.out.println("Create a Canaray classifier with positive and negative images");
   		
		Builder classBuilder = new ClassifierOptions.Builder();
		
		for(int i=0; i<allZipPath.size(); i++){
			//Take the name and add as a name to the class
			classBuilder.addClass(allZipPath.get(i).getName().substring(0, allZipPath.get(i).getName().indexOf('.')) , allZipPath.get(i));	
		}
		ClassifierOptions createCanaryOptions = classBuilder.classifierName("Canary").build();
		
//        you can add negative zip by using ".negativeExamples(new File(myFilePath +"cats.zip")).build()" 
		result = service.createClassifier(createCanaryOptions).execute();
		System.out.println(result);
	   
	/*  while(result.getStatus().toString() =="training"){
		  
		  System.out.print(".");
		  service.getClassifier(classifierId)
		  classifierID = result.getId().toString();
	  }*/
		  
		
	}
	
	

	static void classifyYourImage(){
		
		 System.out.println("Classify using the new classifier which you have created 'Canaray' classifier");
		  /*  while(classifierID==null || result.getStatus().toString() =="training"){System.out.print("processing...");}*/
		    ClassifyImagesOptions option_classify = new ClassifyImagesOptions.Builder().images(new File(myFilePath +"report_finding.image.9c276f4ba9de0835.33333933372e706e67.png"))
		        .classifierIds(classifierID).build();
		    VisualClassification option_result = service.classify(option_classify).execute();
		    System.out.println(option_result);
		
	}
	
	public static void main(String[] args) throws Exception{
	  
		service.setApiKey("caa6385d06cc80c1e01694a8a1e85342383a1cc0");
		

    /* Make your own Custom Classifier
     * In this case(Free API) --> created Canaray named classifier
     * Data requirement -->  Classifier --> up to 5000 iamges
     * Classes --> zip size upto 5MB only
     * Recommendation --> In each class put 50 images
     *  */
	createCustomClassifier();
	
	
    
    
    
    /*  Classify image in your Classifier */
	
//		classifyYourImage();
	
	

	  
    
    
    /* Update Classifier */
    
    
    
    /* Delete Classifier */
	    
    
    
    
    
    
	    
	    
	    /* Choose your Image --> By default it will check from default classifier 
     * You need to check from your custom classifier 
     * In this case Free API - You can just create one Custom classifier
     * */
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
