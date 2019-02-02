package com.lubaszak.utils;

import java.util.ResourceBundle;

public enum FxmlView {

    USER_DETAIL {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("user.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/UserView.fxml";
        }

    }, 
    LOGIN {
        @Override
		public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
		public String getFxmlFile() {
            return "/fxml/LoginView.fxml";
        }


    },
    REGISTER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("register.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/RegisterView.fxml";
        }


    },

    MAIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("main.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/MainView.fxml";
        }


    },

    FOOD_SEARCH {
        @Override
        public String getTitle() {
                return getStringFromResourceBundle("foodadd.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/FoodSearchView.fxml";
        }


    },

    FOOD_INFO {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("foodinfo.title");

        }

        @Override
        public String getFxmlFile() {
            return "/fxml/FoodInfoView.fxml";
        }
    }





    ;
    
    public abstract String getTitle();
    public abstract String getFxmlFile();

    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
