package christmas.validate;

import christmas.domain.menu.Category;
import christmas.domain.menu.MenuInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputMenuValidate {

    private final String PREFIX = "[ERROR] ";
    private final String SUFFIX = "다시 입력해 주세요.\n";

    private final String menu;
    private List<String> menuItems;
    //메뉴명
    private List<String> menuNameValidate;
    //메뉴개수
    private List<Integer> menuCountsValidate;


    public InputMenuValidate(String menu) {
        this.menu = menu;
        menuNameValidate = new ArrayList<>();
        menuCountsValidate = new ArrayList<>();
        menuItems = new ArrayList<>();
    }

    public String validate(){
        splitSetup();
        menuNameCheckValidate();
        menuNameSameValidate();
        menuCountsRangeValidate();
        menuCategoryValidate();
        return menu;
    }

    public void splitSetup(){
        menuItemsSetup();
        splitValidate();
        menuNameValidateSetup();
        menuCountsValidateSetup();
    }

    private void menuItemsSetup() {
        menuItems = Arrays.asList(menu.split(","));
    }

    private void menuCountsValidateSetup() {
        menuCountsValidate = menuItems.stream()
                .map(menuItem -> Integer.parseInt(menuItem.split("-")[1]))
                .collect(Collectors.toList());
    }

    private void menuNameValidateSetup() {
        menuNameValidate = menuItems.stream().map(menuItem -> menuItem.split("-")[0])
                .collect(Collectors.toList());
    }


    public void splitValidate(){
        // menuItem이 다음 형식 "문자-숫자"이 아니면 예외 발생
        if (menuItems.stream().anyMatch(menuItem -> !menuItem.matches(".+-\\d+"))) {
            throw new IllegalArgumentException(PREFIX + "유효하지 않은 주문입니다. " + SUFFIX);
        }
    }

    private void menuNameCheckValidate(){
        // 메뉴명이 메뉴판에 있는 메뉴인가?
        if (menuNameValidate.stream()
                .noneMatch(menuName -> Arrays.stream(MenuInfo.values())
                        .anyMatch(menuInfo -> menuInfo.getName().equals(menuName)))) {
            throw new IllegalArgumentException(PREFIX + "유효하지 않은 주문입니다. " + SUFFIX);
        }
    }

    private void menuNameSameValidate(){
        // 입력한 메뉴명에 중복이 있는가
        if (menuNameValidate.size() != new HashSet<>(menuNameValidate).size()) {
            throw new IllegalArgumentException(PREFIX + "유효하지 않은 주문입니다. " + SUFFIX);
        }
    }


    private void menuCountsRangeValidate() {
        if (menuCountsValidate.stream().anyMatch(count -> count < 1 || count > 20)) {
            throw new IllegalArgumentException(PREFIX + "유효하지 않은 주문입니다. " + SUFFIX);
        }
    }

    private void menuCategoryValidate() {
        // 모든 카테고리가 음료일 경우 예외 발생
        if (menuNameValidate.stream()
                .map(MenuInfo::getCategoryByName)
                .allMatch(category -> category == Category.BEVERAGE)) {
            throw new IllegalArgumentException(PREFIX + "유효하지 않은 주문입니다. " + SUFFIX);
        }
    }



}
