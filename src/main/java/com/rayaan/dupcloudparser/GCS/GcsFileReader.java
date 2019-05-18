package com.rayaan.dupcloudparser.GCS;

import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GcsFileReader {
    private String PROJECT_ID = "ambient-polymer-228615 ";
    private String PATH_TO_JSON_KEY = "./ambient-polymer-228615-cbda2d709bde.json";
    private String BUCKET_NAME;
    private String OBJECT_NAME;

    public String Readfile(String bucket_name, String file_name) throws IOException {
        BUCKET_NAME = bucket_name;
        OBJECT_NAME = file_name;
        /*StorageOptions options = StorageOptions.newBuilder()
                .setProjectId(PROJECT_ID)
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(jsonCredentialPath()))).build();
        Storage storage = options.getService();*/
        Storage storage = StorageOptions.getDefaultInstance().getService();
        Blob blob = storage.get(BUCKET_NAME, OBJECT_NAME);
        String fileContent = new String(blob.getContent());
        return fileContent;
    }
    private String jsonCredentialPath() {
        return System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
    }

    public String credentialJsonFromEnv() throws IOException {
        String jsonFile = jsonCredentialPath();
        if (jsonFile == null || !Files.exists(Paths.get(jsonFile))) {
            throw new IllegalArgumentException(
                    "GOOGLE_APPLICATION_CREDENTIALS needs to be set and point to a valid credential json");
        }
        return new String(Files.readAllBytes(Paths.get(jsonFile)));
    }
}
