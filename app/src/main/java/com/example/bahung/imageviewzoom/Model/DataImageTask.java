package com.example.bahung.imageviewzoom.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class DataImageTask {




        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("user_create")
        @Expose
        private int userCreate;
        @SerializedName("can_delete")
        @Expose
        private boolean canDelete;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUserCreate() {
            return userCreate;
        }

        public void setUserCreate(int userCreate) {
            this.userCreate = userCreate;
        }

        public boolean isCanDelete() {
            return canDelete;
        }

        public void setCanDelete(boolean canDelete) {
            this.canDelete = canDelete;
        }

    }
