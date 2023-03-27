package org.com;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.ConfigurationException;

    public class Configuration  {

        private static PropertiesConfiguration configuration;
        public static final String BROWSER = "browser";
        public static final String URL = "url";

        public static final String CHATQUERY = "chatQuery";
        public static final String PIZZATYPE =  "pizzaType";

        public static final String TOPPING = "topping";
        public static final String CRUST = "crust";
        public static final String SIZE =  "size";
        public static final String FEEDBACK =  "feedback";
        public static final String  RATING = "rating";

        public static final String IMPROVEMENT = "improvement";


        static {
            try {
                configuration = new PropertiesConfiguration("env.properties");
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }

        public String getProperty(String key) {
            return configuration.getString(key);
        }



    }
