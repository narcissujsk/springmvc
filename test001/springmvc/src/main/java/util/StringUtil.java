package util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.filter.LoginFilter;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * String处理类
 * 
 * @author sunny
 * 
 */
public final class StringUtil {
	private static StringUtil instance = new StringUtil();

	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);

	private StringUtil() {
	}

	static StringUtil getInstance() {
		return instance;
	}

	/**
	 * 将参数字符串中的特殊字符进行编码 例如 "Hello world!" 转换后为 "Hello%20world%21"
	 * 
	 * @param src
	 *            源字符串
	 * @return 编码后的字符串
	 */
	// public static String escape(String src) {
	// StringBuffer tmp = new StringBuffer();
	// tmp.ensureCapacity(src.length() * 6);
	//
	// for (int i = 0; i < src.length(); i++) {
	// char j = src.charAt(i);
	//
	// if ((Character.isDigit(j)) || (Character.isLowerCase(j))
	// || (Character.isUpperCase(j))) {
	// tmp.append(j);
	// } else if (j < 'Ā') {
	// tmp.append("%");
	// if (j < '\020')
	// tmp.append("0");
	// tmp.append(Integer.toString(j, 16));
	// } else {
	// tmp.append("%u");
	// tmp.append(Integer.toString(j, 16));
	// }
	// }
	// return tmp.toString();
	// }

	/**
	 * escape()方法的逆运算
	 * 
	 * @param src
	 *            源字符串
	 * @return 解码后的字符串
	 */
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0;
		int pos = 0;

		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					char ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);

					tmp.append(ch);
					lastPos = pos + 6;
					continue;
				}
				char ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);

				tmp.append(ch);
				lastPos = pos + 3;
				continue;
			}

			if (pos == -1) {
				tmp.append(src.substring(lastPos));
				lastPos = src.length();
				continue;
			}
			tmp.append(src.substring(lastPos, pos));
			lastPos = pos;
		}

		return tmp.toString();
	}

	/**
	 * toTrim循环去掉以trimStr开头的字符 例如 String s = "123123Hello123world123123";
	 * trimPrefix(s,"123") - 输出Hello123world123123
	 * 
	 * @param toTrim
	 *            toTrim
	 * @param trimStr
	 *            trimStr
	 * @return String
	 */
	public static String trimPrefix(String toTrim, String trimStr) {
		while (toTrim.startsWith(trimStr)) {
			toTrim = toTrim.substring(trimStr.length());
		}
		return toTrim;
	}

	/**
	 * toTrim循环去掉以trimStr结尾的字符 例如 String s = "123123Hello123world123123";
	 * trimPrefix(s,"123") - 输出123123Hello123world
	 * 
	 * 
	 * @param toTrim
	 *            toTrim
	 * @param trimStr
	 *            trimStr
	 * @return String
	 */
	public static String trimSufffix(String toTrim, String trimStr) {
		while (toTrim.endsWith(trimStr)) {
			toTrim = toTrim.substring(0, toTrim.length() - trimStr.length());
		}
		return toTrim;
	}

	/**
	 * toTrim循环去掉以trimStr开头和结尾的字符 例如 String s = "123123Hello123world123123";
	 * trimPrefix(s,"123") - 输出Hello123world
	 * 
	 * 
	 * @param toTrim
	 *            toTrim
	 * @param trimStr
	 *            trimStr
	 * @return String
	 */
	public static String trim(String toTrim, String trimStr) {
		return trimSufffix(trimPrefix(toTrim, trimStr), trimStr);
	}

	/**
	 * 截取子串
	 * 
	 * @param str
	 *            String
	 * @param len
	 *            长度
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String subString(String str, int len) {
		int strLen = str.length();
		if (strLen < len) {
			return str;
		}
		char[] chars = str.toCharArray();
		int cnLen = len * 2;
		String tmp = "";
		int iLen = 0;
		int charsLength = chars.length;
		for (int i = 0; i < charsLength; i++) {
			int iChar = chars[i];
			if (iChar <= 128) {
				iLen += 1;
			} else {
				iLen += 2;
			}
			if (iLen >= cnLen) {
				break;
			}
			tmp = new StringBuilder().append(tmp).append(String.valueOf(chars[i])).toString();
		}
		return tmp;
	}

	/**
	 * 判断输入参数是否可转换为数字
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isNumberic(String s) {
		// if (StringUtils.isEmpty(s))
		if (s == null) {
			return false;
		}
		boolean rtn = validByRegex("^[-+]{0,1}\\d*\\.{0,1}\\d+$", s);
		if (rtn) {
			return true;
		}

		return validByRegex("^0[x|X][\\da-eA-E]+$", s);
	}

	/**
	 * 判断输入参数是否可转换为整数
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isInteger(String s) {
		boolean rtn = validByRegex("^[-+]{0,1}\\d*$", s);
		return rtn;
	}

	/**
	 * 判断输入参数是否可转换为邮件地址
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isEmail(String s) {
		boolean rtn = validByRegex("(\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)*", s);
		return rtn;
	}

	/**
	 * 判断输入参数是否可转换为手机号码
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isMobile(String s) {
		boolean rtn = validByRegex("^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\\d{8})$", s);
		return rtn;
	}

	/**
	 * 判断输入参数是否可转换为固定号码
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isPhone(String s) {
		boolean rtn = validByRegex("(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?", s);
		return rtn;
	}

	/**
	 * 判断输入参数是否可转换为邮政编码
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isZip(String s) {
		boolean rtn = validByRegex("^[0-9]{6}$", s);
		return rtn;
	}

	/**
	 * 判断输入参数是否可转换为qq号
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isQq(String s) {
		boolean rtn = validByRegex("^[1-9]\\d{4,9}$", s);
		return rtn;
	}

	/**
	 * 判断输入参数是否可转换为IP
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isIp(String s) {
		boolean rtn = validByRegex(
				"^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", s);
		return rtn;
	}

	/**
	 * 判断输入参数是否可转换为中文
	 * 
	 * @param s
	 *            String
	 * @return boolean true：可以 false：不可以
	 */
	public static boolean isChinese(String s) {
		boolean rtn = validByRegex("^[一-龥]+$", s);
		return rtn;
	}

	/**
	 * 判断输入参数是否只包含数字和字母
	 * 
	 * @param s
	 *            String
	 * @return boolean true：是 false：否
	 */
	public static boolean isChrNum(String s) {
		boolean rtn = validByRegex("^([a-zA-Z0-9]+)$", s);
		return rtn;
	}

	/**
	 * 判断input是否符合regex规范
	 * 
	 * @param regex
	 *            正则
	 * @param input
	 *            输入字符串
	 * @return boolean
	 */
	public static boolean validByRegex(String regex, String input) {
		Pattern p = Pattern.compile(regex, 2);
		Matcher regexMatcher = p.matcher(input);
		return regexMatcher.find();
	}

	/**
	 * 判断输入字符串中每一个字符都是数字
	 * 
	 * @param str
	 *            String
	 * @return boolean true:是 false:不是
	 */
	public static boolean isNumeric(String str) {
		int i = str.length();
		if (i == 0) {
			return false;
		}
		while (true) {
			i--;
			if (i < 0) {
				break;
			}
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 首字母转换为大写
	 * 
	 * @param newStr
	 *            String
	 * @return String
	 */
	public static String makeFirstLetterUpperCase(String newStr) {
		if (newStr.length() == 0) {
			return newStr;
		}
		char[] oneChar = new char[1];
		oneChar[0] = newStr.charAt(0);
		String firstChar = new String(oneChar);
		return new StringBuilder().append(firstChar.toUpperCase()).append(newStr.substring(1)).toString();
	}

	/**
	 * 首字母转换为小写
	 * 
	 * @param newStr
	 *            String
	 * @return String
	 */
	public static String makeFirstLetterLowerCase(String newStr) {
		if (newStr.length() == 0) {
			return newStr;
		}
		char[] oneChar = new char[1];
		oneChar[0] = newStr.charAt(0);
		String firstChar = new String(oneChar);
		return new StringBuilder().append(firstChar.toLowerCase()).append(newStr.substring(1)).toString();
	}

	/**
	 * 格式化对象数组信息
	 * 
	 * @param message
	 *            message
	 * @param args
	 *            Object
	 * @return String
	 */
	public static String formatParamMsg(String message, Object[] args) {
		int length = args.length;
		for (int i = 0; i < length; i++) {
			message = message.replace(new StringBuilder().append("{").append(i).append("}").toString(),
					args[i].toString());
		}
		return message;
	}

	/**
	 * 格式化Map对象信息
	 * 
	 * @param message
	 * @param args
	 *            Map
	 * @param <K>
	 *            the type of keys maintained by this map
	 * @param <V>
	 *            the type of mapped values
	 * @return String
	 */
	public static <K, V> String formatParamMsg(String message, Map<K, V> params) {
		if (params == null) {
			return message;
		}
		Iterator<K> keyIts = params.keySet().iterator();
		while (keyIts.hasNext()) {
			String key = (String) keyIts.next();
			Object val = params.get(key);
			if (val != null) {
				message = message.replace(new StringBuilder().append("${").append(key).append("}").toString(),
						val.toString());
			}
		}
		return message;
	}

	/**
	 * formatMsg
	 * 
	 * @param msgWithFormat
	 *            msgWithFormat
	 * @param autoQuote
	 *            autoQuote
	 * @param args
	 *            args
	 * @return StringBuilder
	 * @see [类、类#方法、类#成员]
	 */
	public static StringBuilder formatMsg(CharSequence msgWithFormat, boolean autoQuote, Object[] args) {
		int argsLen = args.length;
		boolean markFound = false;

		StringBuilder sb = new StringBuilder(msgWithFormat);

		if (argsLen > 0) {
			for (int i = 0; i < argsLen; i++) {
				String flag = new StringBuilder().append("%").append(i + 1).toString();
				int idx = sb.indexOf(flag);

				while (idx >= 0) {
					markFound = true;
					sb.replace(idx, idx + 2, toString(args[i], autoQuote));
					idx = sb.indexOf(flag);
				}
			}

			if (args[argsLen - 1] instanceof Throwable) {
				StringWriter sw = new StringWriter();
				((Throwable) args[argsLen - 1]).printStackTrace(new PrintWriter(sw));
				sb.append("\n").append(sw.toString());
			} else if ((argsLen == 1) && (!markFound)) {
				sb.append(args[argsLen - 1].toString());
			}
		}
		return sb;
	}

	/**
	 * formatMsg
	 * 
	 * @param msgWithFormat
	 *            msgWithFormat
	 * @param args
	 *            args
	 * @return StringBuilder
	 * @see [类、类#方法、类#成员]
	 */
	public static StringBuilder formatMsg(String msgWithFormat, Object[] args) {
		return formatMsg(new StringBuilder(msgWithFormat), true, args);
	}

	/**
	 * to String
	 * 
	 * @param obj
	 *            obj
	 * @param autoQuote
	 *            autoQuote
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String toString(Object obj, boolean autoQuote) {
		StringBuilder sb = new StringBuilder();
		if (obj == null) {
			sb.append("NULL");
		} else if (obj instanceof Object[]) {
			int length = ((Object[]) (Object[]) obj).length;
			for (int i = 0; i < length; i++) {
				sb.append(((Object[]) (Object[]) obj)[i]).append(", ");
			}
			if (sb.length() > 0) {
				sb.delete(sb.length() - 2, sb.length());
			}
		} else {
			sb.append(obj.toString());
		}

		if (autoQuote && (sb.length() > 0) && ((sb.charAt(0) != '[') || (sb.charAt(sb.length() - 1) != ']'))
				&& ((sb.charAt(0) != '{') || (sb.charAt(sb.length() - 1) != '}'))) {
			sb.insert(0, "[").append("]");
		}
		return sb.toString();
	}

	/**
	 * return Space
	 * 
	 * @param str
	 *            String
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String returnSpace(String str) {
		String space = "";
		if (!str.isEmpty()) {
			String[] path = str.split("\\.");
			int length = path.length - 1;
			for (int i = 0; i < length; i++) {
				space = new StringBuilder().append(space).append("&nbsp;&emsp;").toString();
			}
		}
		return space;
	}

	/**
	 * get ArrayAs String
	 * 
	 * @param arr
	 *            List
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String getArrayAsString(List<String> arr) {
		if (arr.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		int size = arr.size();
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				sb.append(',');
			}
			sb.append((String) arr.get(i));
		}
		return sb.toString();
	}

	/**
	 * getArrayAsString
	 * 
	 * @param arr
	 *            array
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String getArrayAsString(String[] arr) {
		if ((arr == null) || (arr.length == 0)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		int arrLength = arr.length;
		for (int i = 0; i < arrLength; i++) {
			if (i > 0) {
				sb.append(',');
			}
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	/**
	 * getSetAsString
	 * 
	 * @param set
	 *            set
	 * @param <T>
	 *            the type of elements maintained by this set
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static <T> String getSetAsString(Set<T> set) {
		if (set.isEmpty()) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		int i = 0;
		Iterator<T> it = set.iterator();
		while (it.hasNext()) {
			if (i++ > 0) {
				sb.append(',');
			}
			sb.append(it.next().toString());
		}
		return sb.toString();
	}

	/**
	 * htmlEntityToString
	 * 
	 * @param dataStr
	 *            dataStr
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String htmlEntityToString(String dataStr) {
		dataStr = dataStr.replace("&apos;", "'").replace("&quot;", "\"").replace("&gt;", ">").replace("&lt;", "<")
				.replace("&amp;", "&");

		int start = 0;
		int end = 0;
		StringBuffer buffer = new StringBuffer();

		while (start > -1) {
			int system = 10;
			if (start == 0) {
				int t = dataStr.indexOf("&#");
				if (start != t) {
					start = t;
				}
				if (start > 0) {
					buffer.append(dataStr.substring(0, start));
				}
			}
			end = dataStr.indexOf(";", start + 2);
			String charStr = "";
			if (end != -1) {
				charStr = dataStr.substring(start + 2, end);

				char s = charStr.charAt(0);
				if ((s == 'x') || (s == 'X')) {
					system = 16;
					charStr = charStr.substring(1);
				}
			}
			try {
				char letter = (char) Integer.parseInt(charStr, system);
				buffer.append(new Character(letter).toString());
			} catch (NumberFormatException e) {
				logger.error(e.getMessage());
			}

			start = dataStr.indexOf("&#", end);
			if (start - end > 1) {
				buffer.append(dataStr.substring(end + 1, start));
			}

			if (start == -1) {
				int length = dataStr.length();
				if (end + 1 != length) {
					buffer.append(dataStr.substring(end + 1, length));
				}
			}
		}
		return buffer.toString();
	}

	/**
	 * stringToHtmlEntity
	 * 
	 * @param str
	 *            str
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String stringToHtmlEntity(String str) {
		StringBuffer sb = new StringBuffer();
		int length = str.length();
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);

			switch (c) {
			case '\n':
				sb.append(c);
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '\'':
				sb.append("&apos;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			default:
				if ((c < ' ') || (c > '~')) {
					sb.append("&#x");
					sb.append(Integer.toString(c, 16));
					sb.append(';');
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 处理database使用的特殊字符
	 * 
	 * @param str
	 *            str
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String convertSpecialCharacterforDB(String str) {
		if (null != str && !"".equals(str)) {
			str = str.replaceAll("'", "''");
			str = str.replaceAll("\\\\", "\\\\\\\\");
			str = str.replaceAll("%", "\\\\%");
			str = str.replaceAll("_", "\\\\_");
		}
		return str;
	}

	/**
	 * mybatis查询时，特殊字符处理,rex_like
	 * 
	 * @param queryName
	 *            包含特殊字符的字符串
	 * @return 转译后的字符串
	 */
	public static String mybatisQueryConvert(String queryName) {
		if (queryName != null) {
			queryName = queryName.replace("\\", "\\\\");
			queryName = queryName.replace("$", "\\$");
			queryName = queryName.replace("(", "\\(");
			queryName = queryName.replace(")", "\\)");
			queryName = queryName.replace("[", "\\[");
			queryName = queryName.replace("]", "\\]");
			queryName = queryName.replace("%", "\\%");
			queryName = queryName.replace("?", "\\?");
			queryName = queryName.replace("^", "\\^");
			queryName = queryName.replace("*", "\\*");
			queryName = queryName.replace("+", "\\+");
			queryName = queryName.replace("|", "\\|");
			queryName = queryName.replace(".", "\\.");
			queryName = queryName.replace("_", "\\_");
		}

		return queryName;

	}

	/**
	 * 处理文件名字中的特殊字符
	 * 
	 * @param name
	 *            String
	 * @return String
	 */
	public static String fileNameFilter(String name) {

		if (name.isEmpty() == true) {
			return null;
		}

		else {
			name = name.replace("/", "");
			name = name.replace("*", "");
			name = name.replace("?", "");

			name = name.replace("\"", "");
			name = name.replace(":", "");

			name = name.replace("<", "");
			name = name.replace(">", "");

			name = name.replace("|", "");

			return name;
		}

	}

	/**
	 * get String
	 * 
	 * @param str
	 *            str
	 * @return String
	 * @see [类、类#方法、类#成员]
	 */
	public static String getString(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 解析String
	 * 
	 * @param str
	 *            字符串
	 * @param defaultValue
	 *            默认值
	 * @return 数值
	 */
	public static Double toDouble(String str, Double defaultValue) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 解析String
	 * 
	 * @param str
	 *            字符串
	 * @param defaultValue
	 *            默认值
	 * @return 数值
	 */
	public static Integer toInteger(String str, Integer defaultValue) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 判断两个string是否相等
	 * 
	 * @param str1
	 *            str1
	 * @param str2
	 *            str2
	 * @return 是否相等
	 */
	public static boolean equalIgnoreCase(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}
		return str1.equalsIgnoreCase(str2);
	}

	/**
	 * 把结果合成一行
	 * 
	 * @param obj
	 *            对象
	 * @return 结果
	 */
	public static String compactInOneLine(Object obj) {
		if (obj == null) {
			return "";
		}
		String str = obj.toString();
		if (str == null) {
			return "";
		}
		return str.replace("\n", "");
	}

	/**
	 * 特殊字符处理
	 * 
	 * @param inputName
	 *            字符串
	 * @return 字符串
	 */
	public static String convertSpecialSelName(String inputName) {
		if (!inputName.isEmpty()) {
			inputName = inputName.replace("\\", "\\\\");
			inputName = inputName.replace("$", "\\$");
			inputName = inputName.replace(".", "\\.");
			inputName = inputName.replace("(", "\\(");
			inputName = inputName.replace(")", "\\)");
			inputName = inputName.replace("%", "\\%");
			inputName = inputName.replace("*", "\\*");
			inputName = inputName.replace("?", "\\?");
			inputName = inputName.replace("^", "\\^");
			inputName = inputName.replace("+", "\\+");
			inputName = inputName.replace("|", "\\|");
			inputName = inputName.replace("_", "\\_");
			return inputName;
		}
		return null;
	}

	/**
	 * 获取id与name对
	 * 
	 * @param idStr
	 *            id串，以逗号隔开
	 * @param nameStr
	 *            name串，以逗号隔开
	 * @return Map<String, String> key为id，value为与之对应的name
	 * @author jiww
	 */
	public static Map<String, String> getIDNamePairs(String idStr, String nameStr) {
		Map<String, String> idNamePairs = new HashMap<String, String>(16);
		String[] idArray = idStr.split(",");
		String[] nameArray = nameStr.split(",");
		int len = idArray.length;
		for (int i = 0; i < len; i++) {
			idNamePairs.put(idArray[i], nameArray[i]);
		}

		return idNamePairs;
	}

	/**
	 * 校验字符串最大长度
	 * 
	 * @param str
	 *            要校验的字符串
	 * @param length
	 *            最大长度
	 * @return boolean
	 */
	public static boolean ltLen(String str, int length) {
		return str == null ? true : str.length() <= length;
	}

	/**
	 * 校验字符串最小长度
	 * 
	 * @param str
	 *            要校验的字符串
	 * @param length
	 *            最小长度
	 * @return boolean
	 */
	public static boolean gtLen(String str, int length) {
		return str == null ? false : str.length() >= length;
	}

	/**
	 * 判断文件路径是否合法，防止注入
	 * 
	 * 判断是否包含..这种路径跨越的情况
	 * 
	 * @param str
	 * @return boolean true：文件路径合法 false：文件路径不合法
	 */
	public static boolean isValidFilePath(String str) {
		return str.indexOf("../") < 0;
	}

	public static String toString(Throwable e) {
		StringBuffer buffer = new StringBuffer();
		int rownum = 100;
		buffer.append(e.getMessage()).append("\r\n");
		if (e.getStackTrace().length < 100) {
			rownum = e.getStackTrace().length;
		}
		for (int i = 0; i < rownum; i++) {
			buffer.append(e.getStackTrace()[i].toString()).append("\r\n");
		}
		return buffer.toString();
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static String filterNumber(String number) {

		number = number.replaceAll("[^(0-9)]", "");
		return number;
	}

	public static boolean isEmptyOrNull(String str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}

	public static String transToString(Object obj) {
		String str = obj + "";
		if (str.contains("null")) {
			str = null;
		} else if (str.contains(".")) {
			str = str.substring(0, str.indexOf("."));
		}
		return str;
	}

	/**
	 * 获取字符串拼音的第一个字母
	 * 
	 * @param chinese
	 * @return
	 */
	public static String ToFirstChar(String chinese) {
		String pinyinStr = "";
		char[] newChar = chinese.toCharArray(); // 转为单个字符
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < newChar.length; i++) {
			if (newChar[i] > 128) {
				try {
					pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0].charAt(0);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinStr += newChar[i];
			}
		}
		return pinyinStr;
	}

	/**
	 * 汉字转为拼音
	 * 
	 * @param chinese
	 * @return
	 */
	public static String ToPinyin(String chinese) {
		String pinyinStr = "";
		char[] newChar = chinese.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < newChar.length; i++) {
			if (newChar[i] > 128) {
				try {
					pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinStr += newChar[i];
			}
		}
		return pinyinStr;
	}

	public static boolean isNotBlank(String str) {

		if (str == null || str.length() == 0)
			return false;
		else
			return true;

	}

}
