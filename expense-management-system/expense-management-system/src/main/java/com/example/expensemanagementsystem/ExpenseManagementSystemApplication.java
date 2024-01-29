package com.example.expensemanagementsystem;

import com.example.expensemanagementsystem.command.CommandExecutor;
import com.example.expensemanagementsystem.command.CreateUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing // for auto generation of fields
public class ExpenseManagementSystemApplication implements CommandLineRunner {

    private Scanner scanner;
    private CommandExecutor commandExecutor;

    public ExpenseManagementSystemApplication(CommandExecutor commandExecutor, CreateUserCommand createUserCommand) {
        this.scanner = new Scanner(System.in);
        this.commandExecutor = commandExecutor;
        commandExecutor.addCommand(createUserCommand);
    }
    public static void main(String[] args) {
        SpringApplication.run(ExpenseManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while(true) {
            System.out.println("Enter input: ");
            String input = scanner.nextLine();
            commandExecutor.execute(input);
        }
    }
}
