package sample;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    public ResourceBundle resources;
    @FXML
    public URL location;

    @FXML
    public Label label_field;

    @FXML
    public Button clear_btn;

    @FXML
    public Button plus_minus_btn;

    @FXML
    public Button percent_btn;

    @FXML
    public Button split_btn;

    @FXML
    public Button btn_7;

    @FXML
    public Button btn_8;

    @FXML
    public Button btn_9;

    @FXML
    public Button mult_btn;

    @FXML
    public Button btn_4;

    @FXML
    public Button btn_5;

    @FXML
    public Button btn_6;

    @FXML
    public Button minus_btn;

    @FXML
    public Button btn_1;

    @FXML
    public Button btn_2;

    @FXML
    public Button btn_3;

    @FXML
    public Button plus_btn;

    @FXML
    public Button btn_0;

    @FXML
    public Button koma_btn;

    @FXML
    public Button equal_btn;

    String str_num = "";
    float first_num = 0;
    char operation;

    @FXML
    void initialize() {
        btn_0.setOnAction(event -> {
            addNumber(0);
        });
        btn_1.setOnAction(event -> {
            addNumber(1);
        });
        btn_2.setOnAction(event -> {
            addNumber(2);
        });
        btn_3.setOnAction(event -> {
            addNumber(3);
        });
        btn_4.setOnAction(event -> {
            addNumber(4);
        });
        btn_5.setOnAction(event -> {
            addNumber(5);
        });
        btn_6.setOnAction(event -> {
            addNumber(6);
        });
        btn_7.setOnAction(event -> {
            addNumber(7);
        });
        btn_8.setOnAction(event -> {
            addNumber(8);
        });
        btn_9.setOnAction(event -> {
            addNumber(9);
        });

        plus_btn.setOnAction(event -> {
            mathAction('+');
        });
        split_btn.setOnAction(event -> {
            mathAction('/');
        });
        mult_btn.setOnAction(event -> {
            mathAction('*');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        equal_btn.setOnAction(event -> {
            if (this.operation == '+' || this.operation == '-'
                    || this.operation == '/' || this.operation == '*')
                equalMethod();
        });
        koma_btn.setOnAction(event -> {
            if (!this.str_num.contains(".")) {
                this.str_num += ".";
                label_field.setText(str_num);
            }
        });
        percent_btn.setOnAction(event -> {
            if (this.str_num != "") ;
            float num = Float.parseFloat(this.str_num) * 0.1f;
            this.str_num = Float.toString(num);
            label_field.setText(str_num);
        });
        plus_minus_btn.setOnAction(event -> {
            if (this.str_num != "") ;
            float num = Float.parseFloat(this.str_num) * -1;
            this.str_num = Float.toString(num);
            label_field.setText(str_num);
        });
        clear_btn.setOnAction(event -> {
            label_field.setText("");
            this.str_num = "";
            this.first_num = 0;
            this.operation = 'A';
        });
    }

    void equalMethod() {
        float result = 0;
        switch (this.operation) {
            case '+':
                result = this.first_num + Float.parseFloat(str_num);
                break;
            case '-':
                result = this.first_num - Float.parseFloat(str_num);
                break;
            case '/':
                if (Integer.parseInt(str_num) != 0)
                    result = this.first_num / Float.parseFloat(str_num);
                else
                    result = 0;
                break;
            case '*':
                result = this.first_num * Float.parseFloat(str_num);
                break;
        }
        label_field.setText(Float.toString(result));
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }

    void mathAction(char operation) {
        if (this.operation != '+' && this.operation != '-'
                && this.operation != '/' && this.operation != '*') {
            this.first_num = Float.parseFloat(this.str_num);
            label_field.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }
    }

    void addNumber(int number) {
        this.str_num += Integer.toString(number);
        label_field.setText(str_num);
    }
}
