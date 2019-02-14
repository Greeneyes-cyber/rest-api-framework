package net.framework.api.rest.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * オブジェクト操作のユーティリティクラス。
 */
public class ObjectUtil {

    /**
     * オブジェクトの空、もしくはnullを検査します.
     * @param input
     * @return
     */
    public static <T> boolean isNullOrEmpty(T input) {
        // 入力がnullのケース
        if (input == null) {
            return true;
        }

        // 入力が空のケース
        if(Objects.equals(input, "")) {
            return true;
        }

        return false;
    }

	/**
	 * 与えられた引数からリストを作成します。
	 * @param ...t 一つ以上のオブジェクト、全て同じ型を指定する
	 * @return List<T> 引数で与えられたオブジェクトを結合したリスト
	 */
	public <T> List<T> convertToList(T...t) {
		List<T> result = new ArrayList<>();
		for (T instance : t) {
			result.add(instance);
		}
		return result;
	}

    /**
     * 引数がURLの形式に則っていることを確認します。
     * @param subject 検査対象パス
     * @return 真偽値
     */
	public boolean isUri(String subject){
	    String regex = "^(http|https)://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(subject);
        if(!matcher.matches()){
            return false;
        }
        return true;
    }

	/**
     * 任意の型のリストからStreamを返します.リストが空の場合、空のStreamを返却します。
     * @param List<T> list
     * @return Stream<T>
     */
    public static <T> Stream<T> getStream(List<T> list) {
        if(list == null) {
            return Stream.empty();
        }
        return list.stream();
    }
}
