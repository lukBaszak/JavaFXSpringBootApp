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

        @Override
        public String getCssStyle() {
            return null;
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

        @Override
        public String getCssStyle() {
            return null;
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

        @Override
        public String getCssStyle() {
            return null;
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

        @Override
        public String getCssStyle() {
            return null;
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

        @Override
        public String getCssStyle() {
            return null;
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

        @Override
        public String getCssStyle() {
            return null;
        }
    },

    QUANTITY {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("quantity.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/QuantityView.fxml";
        }

        @Override
        public String getCssStyle() {
            return null;
        }
    };


    public abstract String getTitle();
    public abstract String getFxmlFile();
    public abstract String getCssStyle();
    
    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }


}
