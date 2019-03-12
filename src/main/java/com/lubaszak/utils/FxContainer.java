package com.lubaszak.utils;

public enum FxContainer {
    RESULT_BOX {
        @Override
        public String getBoxPath() {
            return "/fxml/ResultBox.fxml";
        }
    },

    QUANTITY_BOX {
        @Override
        public String getBoxPath() {
            return "/fxml/QuantityBox.fxml";
        }
    };


    public abstract String getBoxPath();
}
