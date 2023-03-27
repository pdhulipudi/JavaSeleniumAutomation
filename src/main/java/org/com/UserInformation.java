package org.com;

import static org.com.Configuration.*;
    public class UserInformation extends BasePage {
        Configuration configuration = new Configuration();
        private String browser;
        private String url;
        private String chatQuery;
        private String pizzaType;
        private String topping;
        private String crust;
        private String size;
        private String feedback;
        private String rating;

        private String improvement;
        public String getChatQuery() {
            return chatQuery;
        }

        public void setChatQuery(String chatQuery) {
            this.chatQuery = chatQuery;
        }

        public String getPizzaType() {
            return pizzaType;
        }

        public void setPizzaType(String pizzaType) {
            this.pizzaType = pizzaType;
        }

        public String getCrust() {
            return crust;
        }

        public void setCrust(String crust) {
            this.crust = crust;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getTopping() {
            return topping;
        }

        public void setTopping(String topping) {
            this.topping = topping;
        }

        public String getImprovement() {
            return improvement;
        }

        public void setImprovement(String improvement) {
            this.improvement = improvement;
        }

        public UserInformation() {
            this.browser = configuration.getProperty(BROWSER);
            this.url = configuration.getProperty(URL);
            this.chatQuery = configuration.getProperty(CHATQUERY);
            this.pizzaType = configuration.getProperty(PIZZATYPE);
            this.topping = configuration.getProperty(TOPPING);
            this.crust = configuration.getProperty(CRUST);
            this.size = configuration.getProperty(SIZE);
            this.feedback = configuration.getProperty(FEEDBACK);
            this.rating = configuration.getProperty(RATING);
            this.improvement = configuration.getProperty(IMPROVEMENT);
        }


        public String getBrowser() {
            return browser;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setBrowser(String browser) {
            this.browser = browser;
        }
    }
