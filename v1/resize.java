/**
Usage:

java resize.java main.cpp

@author Jack Meng
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class resize {
  public static String[] getContent(String f) {
    try (Scanner s = new Scanner(new File(f))) {
      List<String> lines = new ArrayList<>();
      while (s.hasNextLine()) {
        lines.add(s.nextLine());
      }
      return lines.toArray(new String[0]);
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    return new String[0];
  }

  public static void main(String[] args) {
    String[] content = getContent(args[0]);
    StringBuilder sb = new StringBuilder();
    for (String s : content) {
      if (s.endsWith(";") || s.endsWith("{") || s.endsWith("}")) {
        s = s.replaceAll("\\s+", " ");
        sb.append(s);
      } else {
        sb.append(s + "\n");
      }
    }
    String s = sb.toString();
    s = s.replace(" = ", "=");
    s = s.replace(") {", "){");
    s = s.replace("( ", "(");
    s = s.replace(" % ", "%");
    s = s.replace(" == ", "==");
    s = s.replace(" != ", "!=");
    s = s.replace(" >= ", ">=");
    s = s.replace(" <= ", "<=");
    s = s.replace(" > ", ">");
    s = s.replace(" < ", "<");
    s = s.replace(" + ", "+");
    s = s.replace(" - ", "-");
    s = s.replace(" * ", "*");
    s = s.replace(" / ", "/");
    s = s.replace(" && ", "&&");
    s = s.replace(" || ", "||");
    s = s.replace(" ? ", "?");
    s = s.replace(" : ", ":");
    s = s.replace(" -= ", "-=");
    s = s.replace(" += ", "+=");
    s = s.replace(" /= ", "/=");
    s = s.replace(" *= ", "*=");
    s = s.replace(" ^= ", "^=");
    s = s.replace(" >> ", ">>");
    s = s.replace(" << ", "<<");
    s = s.replace(" >>= ", ">>=");
    s = s.replace(" <<= ", "<<=");
    s = s.replace(" if ", "if");
    s = s.replace(" else ", "else");
    s = s.replace(" for ", "for");
    s = s.replace(" while ", "while");
    s = s.replace(" do ", "do");
    s = s.replace(" switch ", "switch");
    s = s.replace(" case ", "case");
    s = s.replace(" default ", "default");
    s = s.replace("{ ", "{");
    s = s.replace(" }", "}");
    s = s.replace("} ", "}");
    s = s.replace(" {", "{");
    s = s.replace("; ", ";");
    System.out.println(s);
    try (PrintWriter pw = new PrintWriter(new File(args[0] + System.currentTimeMillis() + ".cpp"))) {
      pw.println(s);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
