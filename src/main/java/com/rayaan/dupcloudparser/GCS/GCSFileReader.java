package com.rayaan.dupcloudparser.GCS;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class GCSFileReader {

   public void readBlob(String bucketName,String objectName){
       BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
       BlobKey blobKey = blobstoreService.createGsBlobKey(
               "/gs/" + bucketName + "/" + objectName);
       byte[] Data=blobstoreService.fetchData(blobKey,1,10);
       System.out.println(Data.toString());
       //blobstoreService.serve(blobKey, resp);
   }
}
