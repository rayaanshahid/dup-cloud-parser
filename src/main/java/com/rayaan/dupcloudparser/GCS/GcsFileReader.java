package com.rayaan.dupcloudparser.GCS;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GcsFileReader {
    private String PROJECT_ID = "ambient-polymer-228615 ";
    private String PATH_TO_JSON_KEY = "/Home/sysco/key/ambient-polymer-228615-cbda2d709bde.json";
    private String BUCKET_NAME;
    private String OBJECT_NAME;

    public String Readfile(String bucket_name, String file_name) throws IOException {
        BUCKET_NAME = bucket_name;
        OBJECT_NAME = file_name;
        StorageOptions options = StorageOptions.newBuilder()
                .setProjectId(PROJECT_ID)
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(PATH_TO_JSON_KEY))).build();
        Storage storage = options.getService();
        Blob blob = storage.get(BUCKET_NAME, OBJECT_NAME);
        String fileContent = new String(blob.getContent());
        return fileContent;
    }
}
