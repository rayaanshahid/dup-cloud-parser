package com.rayaan.dupcloudparser.GCS;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.StorageOptions;

import static java.nio.charset.StandardCharsets.UTF_8;

public class GCSBlobReader {
    public String readBlob(String bucketName,String objectName){
        Storage storage = StorageOptions.getDefaultInstance().getService();
        BlobId blobId = BlobId.of(bucketName, objectName);
        byte[] content = storage.readAllBytes(blobId);
        return new String(content, UTF_8);
    }
}
