package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Lesson> lesson = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();
        sc.nextLine();

        int totalDuration = 0;

        for (int i = 0; i < n; i++) {

            System.out.printf("Dados da %sa aula:\n", (i + 1));
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char lessonType = sc.next().charAt(0);
            sc.nextLine();
            if (lessonType == 'c') {
                System.out.print("Título: ");
                String title = sc.nextLine();
                System.out.print("Url do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                lesson.add(new Video(title, url, seconds));
            }  else if (lessonType == 't') {
                System.out.print("Título: ");
                String title = sc.nextLine();
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int tasks = sc.nextInt();
                lesson.add(new Task(title, description, tasks));
            }
        }

        for (Lesson lesson1 : lesson) {
            totalDuration += lesson1.duration();
        }

        System.out.printf("DURAÇÃO TOTAL DO CURSO = %s segundos", totalDuration);





        sc.close();

    }
}
