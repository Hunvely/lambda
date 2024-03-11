package com.rod.api.crawler;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {

    public static void main(Scanner input) throws IOException {

        CrawlerController crawlerController = new CrawlerController();

        while (true) {
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1 - 벅스뮤직\n " +
                    "2 - 멜론\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n " +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n " +
                    "8-직업검색\n " +
                    "9-회원수");
            switch (input.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1 - 벅스뮤직");
                    Map<String, ?> bugsMap = crawlerController.findBugsMusic(input);
                    Iterator<Element> bugsRank = (Iterator<Element>) bugsMap.get("rank");
                    Iterator<Element> bugsTitle = (Iterator<Element>) bugsMap.get("title");
                    Iterator<Element> bugsArtist = (Iterator<Element>) bugsMap.get("artist");

                    System.out.println("벅스뮤직 결과 : ");
                    while (bugsRank.hasNext()) {
                        System.out.println(bugsRank.next().text() + "위 " + bugsArtist.next().text() + " - " + bugsTitle.next().text());
                    }
                    break;
                case "2":
                    System.out.println("2 - 멜론뮤직");
                    Map<String, ?> melonMap = crawlerController.findMelonMusic(input);
                    Iterator<Element> melonRank = (Iterator<Element>) melonMap.get("rank");
                    Iterator<Element> melonTitle = (Iterator<Element>) melonMap.get("title");
                    Iterator<Element> melonArtist = (Iterator<Element>) melonMap.get("artist");
                    System.out.println("멜론뮤직 결과 : ");
                    while (melonRank.hasNext()) {
                        System.out.println(melonRank.next().text() + "위 " + melonArtist.next().text() + " - " + melonTitle.next().text());
                    }
                    break;
                case "3":
                    System.out.println("3-ID검색");
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    break;
                case "6":
                    System.out.println("6-회원목록");
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    break;
                case "9":
                    System.out.println("9-회원수");
                    break;

            }
        }
    }
}
