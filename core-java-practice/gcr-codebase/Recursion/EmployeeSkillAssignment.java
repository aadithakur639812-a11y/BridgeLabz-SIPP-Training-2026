import java.util.Scanner;

public class EmployeeSkillAssignment {
    public static void findProjectTeams(int[] skills, int target, int index, int[] team, int teamSize) {
        if (target == 0) {
            printTeam(team, teamSize);
            return;
        }

        if (index == skills.length || target < 0) {
            return;
        }

        team[teamSize] = skills[index];
        findProjectTeams(skills, target - skills[index], index + 1, team, teamSize + 1);
        findProjectTeams(skills, target, index + 1, team, teamSize);
    }

    public static void printTeam(int[] team, int teamSize) {
        System.out.print("[");
        for (int i = 0; i < teamSize; i++) {
            System.out.print(team[i]);
            if (i < teamSize - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int size = scanner.nextInt();
        int[] skills = new int[size];

        System.out.println("Enter employee skill scores:");
        for (int i = 0; i < size; i++) {
            skills[i] = scanner.nextInt();
        }

        System.out.print("Enter target skill score: ");
        int target = scanner.nextInt();

        int[] team = new int[size];
        findProjectTeams(skills, target, 0, team, 0);

        scanner.close();
    }
}
