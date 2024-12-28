package org.example.twistmaster;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class HelloController {

        @FXML
        private Button AutoButton, CloseButton, HandMadeButton, SettingsButton, SaveButton, StopButton;
        @FXML
        private Pane SettingsPanell;
        @FXML
        private TextField TimerTextField;
        @FXML
        private Label PersonColorLabel, PersonTextLabel, AttempCounterLabel;

        static boolean showSettingsPanel = false;
        static int counter = 0;
        int timer = 5;
        static int AttempCounter = 0;
        private Timeline timeline; // Таймер
        private boolean buttonPressed = false; // Стан кнопки


        @FXML
        void SaveButtonAction(ActionEvent event) {
                timer = Integer.parseInt(TimerTextField.getText());
                TimerTextField.setText(" ");
                System.out.println(timer);
                SettingsPanell.setVisible(false);
        }
        @FXML
        void AutoButtonAction(ActionEvent event) {
                if (!buttonPressed) {
                        // Якщо цикл не запущено
                        buttonPressed = true;
                        AutoButton.setText("Стоп"); // Змінюємо текст кнопки

                        if (timeline != null && timeline.getStatus() == Timeline.Status.RUNNING) {
                                return; // Якщо таймер уже працює, виходимо
                        }

                        timeline = new Timeline(new KeyFrame(Duration.seconds(timer), e -> {
                                // Генеруємо випадкове число та змінюємо текст
                                switch (generateRandomNumber()) {
                                        case 1:
                                                PersonTextLabel.setText("Ліва нога");
                                                break;
                                        case 2:
                                                PersonTextLabel.setText("Ліва рука");
                                                break;
                                        case 3:
                                                PersonTextLabel.setText("Права нога");
                                                break;
                                        case 4:
                                                PersonTextLabel.setText("Права рука");
                                                break;
                                }

                                // Генеруємо випадкове число та змінюємо стиль
                                switch (generateRandomNumber()) {
                                        case 1:
                                                PersonColorLabel.setStyle("-fx-background-color: #fa1b48; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                                break;
                                        case 2:
                                                PersonColorLabel.setStyle("-fx-background-color: #dbf725; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                                break;
                                        case 3:
                                                PersonColorLabel.setStyle("-fx-background-color: #18de4a; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                                break;
                                        case 4:
                                                PersonColorLabel.setStyle("-fx-background-color: #1132ed; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                                break;
                                        default:
                                                PersonColorLabel.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                                break;
                                }

                                // Збільшуємо лічильник спроб та оновлюємо текст
                                AttempCounter++;
                                AttempCounterLabel.setText(String.valueOf(AttempCounter));
                        }));

                        timeline.setCycleCount(Timeline.INDEFINITE); // Цикл виконується нескінченно
                        timeline.play(); // Запускаємо таймер

                } else {
                        // Якщо цикл запущено, зупиняємо
                        buttonPressed = false;
                        AutoButton.setText("Автоматично"); // Змінюємо текст кнопки

                        if (timeline != null) {
                                timeline.stop(); // Зупиняємо таймер
                        }
                }
        }

        @FXML
        void CloseButtonAction(ActionEvent event) {
                javafx.application.Platform.exit();
        }

        @FXML
        void HandMadeButtonAction(ActionEvent event) {
                switch (generateRandomNumber()) {
                        case 1:
                                PersonTextLabel.setText("Ліва нога");
                                break;
                        case 2:
                                PersonTextLabel.setText("Ліва рука");
                                break;
                        case 3:
                                PersonTextLabel.setText("Права нога");
                                break;
                        case 4:
                                PersonTextLabel.setText("Права рука");
                                break;
                }
                switch (generateRandomNumber()) {
                        case 1:
                                PersonColorLabel.setStyle("-fx-background-color: #fa1b48; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                break;
                        case 2:
                                PersonColorLabel.setStyle("-fx-background-color: #dbf725; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                break;
                        case 3:
                                PersonColorLabel.setStyle("-fx-background-color: #18de4a; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                break;
                        case 4:
                                PersonColorLabel.setStyle("-fx-background-color: #1132ed; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                break;
                        default:
                                PersonColorLabel.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50%; -fx-min-width: 100px; -fx-min-height: 100px;");
                                break;
                }
                AttempCounter++;
                AttempCounterLabel.setText(String.valueOf(AttempCounter));
        }

        @FXML
        void SettingsButtonAction(ActionEvent event) {
                showSettingsPanel = !showSettingsPanel;
                if (showSettingsPanel) {
                        SettingsPanell.setVisible(true);
                        System.out.println("true");
                } else {
                        SettingsPanell.setVisible(false);
                        System.out.println("false");
                }
        }
        public int generateRandomNumber() {
                Random random = new Random();
                return random.nextInt(4) + 1; // Генерує число від 0 до 4 і додає 1
        }
    }

