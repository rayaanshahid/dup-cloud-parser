package com.rayaan.dupcloudparser.GCS;

import com.google.appengine.api.ThreadManager;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

import static java.nio.charset.StandardCharsets.UTF_8;

public class GCSFileReader {
   public String readBlob(String bucketName,String objectName){
       BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
       BlobKey blobKey = blobstoreService.createGsBlobKey(
               "/gs/" + bucketName + "/" + objectName);
       byte[] Data=blobstoreService.fetchData(blobKey,1,10);
       return new String(Data,UTF_8);
       //blobstoreService.serve(blobKey, resp);
   }
}
