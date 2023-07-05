import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Create the HashMap that stores the classes
        Map<String, List<String>> schoolMap = new HashMap<>();

        // Initialize the classrooms
        List<String> classroom1A = new ArrayList<>();
        List<String> classroom1B = new ArrayList<>();
        List<String> classroom2A = new ArrayList<>();
        List<String> classroom2B = new ArrayList<>();
        List<String> classroom3A = new ArrayList<>();

        /**
         * Male names:
         * oğuzhan - furkan - osman - serkan - ayhan - kenan
         * süleyman - yaman - hasan - hakan - ilkcan - berkcan
         *
         * Female names:
         * nazlıcan - neslihan - dilan - istemihan - aslıhan - nuran
         * nalan - canan - nagehan - asuman - imran - sultan - mercan
         *
         * Surnames to test if the program works as intended:
         * erdoğan - arslan
         */

        // Add students to the classrooms
        classroom1A.add("Nazlıcan Salman");
        classroom1A.add("Ahmet Erdoğan");
        classroom1A.add("Fatma Demir");
        classroom1A.add("Ali Mehmet Hakan Fidan");
        classroom1A.add("Şener Şenoğlu");

        classroom1B.add("Hasan Karabasan");
        classroom1B.add("Nurgül Esen Akgül");
        classroom1B.add("Kadir Şensoy");
        classroom1B.add("Ahmet Mehmet Ali Veli Yıldırım");

        classroom2A.add("Süleyman Yaman");
        classroom2A.add("Davut Yaman");
        classroom2A.add("Musa Yaman");
        classroom2A.add("Ebubekir Sıddık Abdulrahman Hocaoğlu");
        classroom2A.add("Semra Erdoğan");

        classroom2B.add("İsmail Yavuz Bülent Hakkı Anıl Faruk Şamil Rahmi Hasan Yılmaz");
        classroom2B.add("Hilal Kaplan");
        classroom2B.add("Ayşe Fatma Hatice Münevver Rükiye Nalan Kaplan");
        classroom2B.add("Enes Ünal");
        classroom2B.add("Ela Gül");

        classroom3A.add("Metin Korkmaz");
        classroom3A.add("Çiğdem Demir");
        classroom3A.add("Meryem Öztürk");
        classroom3A.add("Aslıhan Turan");
        classroom3A.add("Berat Turan");
        classroom3A.add("Efe Yalçın");
        classroom3A.add("Burak Yıldırım");

        schoolMap.put("1-A", classroom1A);
        schoolMap.put("1-B", classroom1B);
        schoolMap.put("2-A", classroom2A);
        schoolMap.put("2-B", classroom2B);
        schoolMap.put("3-A", classroom3A);

        // Get the keys
        Set<String> keySet = schoolMap.keySet();

        final String suffix = "an";

        // Iterate over the keys
        // triple loops baby
        for (String key : keySet) {
            // Iterate over the student names
            schoolMap.get(key).forEach(name ->
                    {
                        String[] nameArray = name.split(" ");

                        // Iterate over each name
                        // Exclude the surname
                        for (int i = 0; i < nameArray.length - 1; i++) {
                            if (nameArray[i].endsWith(suffix)) {
                                System.out.println("Class: " + key + " - Student Name: " + name);
                                break;
                            }
                        }
                    }
            );
        }
    }
}