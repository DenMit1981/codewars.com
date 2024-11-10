//Almost every company has a specific acronym for each employee, which is the first letter of their first and last name.
//Your task is to write an acronym generator that generates an acronym for a given name.
//You don't have to worry about repeating acronyms (someone else will do that for you).
//Note that names can be in both upper and lower case.
//The acronym should always be upper case.
//Usually, the acronym is always the first letter of your first name and the first letter of your last name, all in
//upper case.
//For example:
//Thomas Meyer => TM
//Martin Schmidt => MS
//Your company only employs people with a maximum of two first names. If a person has two first names, they can be
//connected with a dash.
//Jan-Erich Schmidt => JES Jan Erich Müller => JEM
//Surnames can also be connected with a dash. No one can have more than two surnames.
//Paul Meyer-Schmidt
//In Germany, there are surnames in which the leading word is "von". This is abbreviated with a lowercase "v":
//Paul von Lahnstein => PvL
//Martin von Lahnstein-Mayer => MvLM

public class AcronymGenerator {
    public static void main(String[] args) {
        System.out.println(createAcronym("Meyer", "Thomas")); //TM
        System.out.println(createAcronym("Meyer-Schmidt", "Paul")); //PMS
        System.out.println(createAcronym("Mueller", "Jan Erich")); //JEM
        System.out.println(createAcronym("Schmidt", "Jan-Erich")); //JES
        System.out.println(createAcronym("von Lahnstein", "Peter")); //PvL
    }

    public static String createAcronym(String lastName, String firstName) {
        StringBuilder sb = new StringBuilder();
        String[] name = getStringFromSurname(firstName).split(" ");
        String[] surname = getStringFromSurname(lastName).split(" ");
        for (String s : name) {
            sb.append(s.charAt(0));
        }

        for (String s : surname) {
            sb.append(s.charAt(0));
        }
        return sb.toString();
    }

    private static String getStringFromSurname(String surname) {
        return surname.replaceAll("-", " ").toUpperCase().replaceAll("VON ", "von ");
    }
}
