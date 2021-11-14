package io.github.mrzakiakkari.streamsworksheet2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author M.Zaki Al Akkari <https://github.com/MrZakiakkari>
 */
public class Worksheet
{

	public static void main(String[] args)
	{

		List<Integer> List = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<String> list2 = new ArrayList<>(Arrays.asList("The", "quick", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"));

		System.out.println("Solution to task 1");
		System.out.println(Arrays.toString(evenNumberArray(List)));
		System.out.println("------------------");
		System.out.println("Solution to task 2");
		System.out.println(firstWordEndingWithE(list2));
		System.out.println("------------------");
		System.out.println("Solution to task 3");
		System.out.println(parallelFirstWordEndingWithE(list2));
		System.out.println("------------------");
		System.out.println("Solution to task 4");
		System.out.println(lengthOfLongestOWord(list2));
		System.out.println("------------------");
		System.out.println("Solution to task 5");
		System.out.println(uppercaseLowercaseList(list2));
		System.out.println("------------------");
		System.out.println("Solution to task 6");
		System.out.println(sumOfSquaredNumbers(List));
		System.out.println("------------------");
	}
	static Integer[] evenNumberArray(List<Integer> list)
	{
		return list.stream().filter(num -> num % 2 == 0).toArray(Integer[]::new);

	}
	static String firstWordEndingWithE(List<String> list)
	{

		return list.stream().filter(str -> str.endsWith("e")).findFirst().orElse("The stream was empty");
	}
	static Stream<String> parallelFirstWordEndingWithE(List<String> list)
	{
		return list.stream().parallel();//work in progress
	}
	static Integer lengthOfLongestOWord(List<String> list)
	{
		Comparator<Integer> solution = (int1, int2) -> int1 - int2;
		return list.stream().filter(str -> str.contains("o")).map(s -> s.length()).max(solution).orElse(-1);
	}
	static List<String> uppercaseLowercaseList(List<String> list)
	{
		return list.stream().map(str -> str.toUpperCase() + (" ") + str.toLowerCase()).collect(Collectors.toList());
	}
	static Integer sumOfSquaredNumbers(List<Integer> list)
	{
		BinaryOperator<Integer> accumulator = (carry, num) ->
		{
			Integer result = num + carry;
			System.out.println("num: " + num + ", carry: " + carry + ", result: " + result);
			//The returned result becomes the new carry value
			return result;
		};

		return list.stream().map(N -> N * N).reduce(0, accumulator);
	}
}
