package com.google.myapplicationstudy;

/**
 * Created by tiankai on 2017/10/30.
 */
public class MyData {
        int type;
        String text;

        public MyData(int type, String text) {
            this.type = type;
            this.text = text;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "MyData{" +
                    "type=" + type +
                    ", text='" + text + '\'' +
                    '}';
        }
}
