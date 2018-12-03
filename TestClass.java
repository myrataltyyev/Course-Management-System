import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class TestClass {

	public static void main(String[] args) {
		Random rand = new Random();
		// first scanner for integers
		Scanner input1 = new Scanner(System.in);
		// second scanner for strings
		Scanner input2 = new Scanner(System.in);
		
		Student[] students = new Student[5];
		students[0] = new Student("2000","Muhammed Ali","Software Engineering");
		students[0].setEmail();
		students[1] = new Student("1010","Haruto Yuto","Philosophy");
		students[1].setEmail();
		students[2] = new Student("3050","Mariyam Imran","Biomedical Engineering");
		students[2].setEmail();
		students[3] = new Student("4020","Karina Hamid","Mathematic");
		students[3].setEmail();
		students[4] = new Student("6000","Maria Dematra","Literature");
		students[4].setEmail();
		
		Course[] courses = new Course[5];
		courses[0] = new Course();
		courses[0].setCid("101");
		courses[0].setDescription("Physics");
		
		courses[1] = new Course();
		courses[1].setCid("203");
		courses[1].setDescription("Computer Programming");
		
		courses[2] = new Course();
		courses[2].setCid("305");
		courses[2].setDescription("Technical Writing");
		
		courses[3] = new Course();
		courses[3].setCid("204");
		courses[3].setDescription("Calculus");
		
		courses[4] = new Course();
		courses[4].setCid("306");
		courses[4].setDescription("Fundamentals of Mathematics");
		
		double[] allRates = {0.1,0.15,0.2,0.25,0.3,0.35,0.4,0.45,0.5,0.55,0.6,0.65,0.7,0.75,0.8,0.85};
		
		
		for (int i = 0; i < courses.length; i++) 
		{
			double[] chosenRates = new double[3];
			
			do{
				chosenRates[0] = allRates[rand.nextInt(8)];
				chosenRates[1] = allRates[rand.nextInt(8)];
				chosenRates[2] = allRates[rand.nextInt(8)];
			} while (!(chosenRates[0] + chosenRates[1] + chosenRates[2] == 1));
			
			courses[i].setEval(chosenRates);
		}
		
		TakeCourse[] takenCourses = new TakeCourse[students.length];
		
		for (int i = 0; i < takenCourses.length; i++) 
		{
			takenCourses[i] = new TakeCourse(students[rand.nextInt(5)],courses[rand.nextInt(5)]);
		}
		
		// starting output...
		int selection;
		
		do {
			System.out.println("\n");
			for (int i = 0; i < 100; i++) 
			{
				System.out.print("-");
			}
			System.out.println();

			String[] menu = {"1-List Course","2-List Student","3-Add Student","4-Add Course","5-List Taken Course","6-Take Course","7-Drop Course","8-Search"};
			String[] listCourseMenu = {"CID","Course Description","Midterm1","Midterm2","Final"};
			String[] listStudentMenu = {"SID","Name","Department","E-mail"};

			for (int i = 0; i < menu.length; i++) 
			{
				System.out.printf("%-25s",menu[i]);
				if (i == 3) System.out.println();
			}

			System.out.println();
			for (int i = 0; i < 100; i++) 
			{
				System.out.print("-");
			}
			
			System.out.print("\nSelection: ");
			selection = input1.nextInt();
			
			switch (selection)
			{
				case 1: System.out.println();
						for (int i = 0; i < listCourseMenu.length; i++)
						{
							if (i == 0) System.out.printf("%-5s",listCourseMenu[i]);
							else if (i == 1) System.out.printf("%-30s",listCourseMenu[i]);
							else System.out.printf("%-20s",listCourseMenu[i]);
						}
						System.out.println();
					
						for (int i = 0; i < courses.length; i++) 
						{
							courses[i].display();
						}
						
						break;
						
				case 2: System.out.println();
						for (int i = 0; i < listStudentMenu.length; i++) 
						{
							if (i == 0) System.out.printf("%-7s",listStudentMenu[i]);
							else if (i == 1) System.out.printf("%-20s",listStudentMenu[i]);
							else System.out.printf("%-30s",listStudentMenu[i]);
						}
						System.out.println();
						
						for (int i = 0; i < students.length; i++) 
						{
							students[i].display();
						}
						
						break;
						
				case 3: boolean newSID = true;
						String sid = "";
						
						// doesn't allow to enter the same ID that already exists
						do{
							System.out.print("SID: ");
							sid = input2.nextLine();
							
							for (int i = 0; i < students.length; i++) 
							{
								if (sid.equals(students[i].getId()))
								{
									newSID = false;
									System.out.println("\tThere exists a student with this ID! Enter another one");
									break;
								}
								else
									newSID = true;
							}
							
						} while (!newSID);
						
						System.out.print("Name: ");
						String name = input2.nextLine();
						
						System.out.print("Department: ");
						String department = input2.nextLine();
						
						// expands "students" array and creates new object
						students = Arrays.copyOf(students, students.length + 1);
						students[students.length - 1] = new Student(sid,name,department);
						students[students.length - 1].setEmail();
						
						System.out.println(students[students.length - 1].toString()+" student is placed into student array");
						break;
						
				case 4:	boolean newCID = true;
						String cid = "";
				
						// doesn't allow to enter the same ID that already exists
						do{
							System.out.print("CID: ");
							cid = input2.nextLine();
					
							for (int i = 0; i < courses.length; i++) 
							{
								if (cid.equals(courses[i].getCid()))
								{
									newCID = false;
									System.out.println("\tThere exists a course with this ID! Enter another one");
									break;
								}
								else
									newCID = true;
							}
					
						} while (!newCID);
					
						System.out.print("Course description: ");
						String description = input2.nextLine();
						
						// expands "courses" array and creates new object
						courses = Arrays.copyOf(courses, courses.length + 1);
						courses[courses.length - 1] = new Course();
						courses[courses.length - 1].setCid(cid);
						courses[courses.length - 1].setDescription(description);
						
						// sets evaluation process
						double[] chosenRate = new double[3];
						do{
							chosenRate[0] = allRates[rand.nextInt(8)];
							chosenRate[1] = allRates[rand.nextInt(8)];
							chosenRate[2] = allRates[rand.nextInt(8)];
						} while (!(chosenRate[0] + chosenRate[1] + chosenRate[2] == 1));
						
						courses[courses.length - 1].setEval(chosenRate);
						
						System.out.println(courses[courses.length - 1].toString()+" course is placed into course array");
						break;
						
				case 5: System.out.println();
						for (int i = 0; i < listCourseMenu.length; i++) 
						{
							switch (i)
							{
								case 0: System.out.printf("%-7s",listStudentMenu[i]); break;
								case 1: System.out.printf("%-20s",listStudentMenu[i]); break;
								case 2: System.out.printf("%-25s",listStudentMenu[i]); break;
								case 3: System.out.printf("%-15s",listCourseMenu[0]); break;
								default: System.out.println(listCourseMenu[1]);
							}
						}
						
						for (int i = 0; i < takenCourses.length; i++) 
						{
							takenCourses[i].display();
						}
						
						break;
						
				case 6:	boolean validSID = false;
						int indexSID = 0;
						
						// takes valid Student ID
						do{
							System.out.print("SID: ");
							sid = input2.nextLine();
							
							for (int i = 0; i < students.length; i++) 
							{
								if (sid.equals(students[i].getId()))
								{
									validSID = true;
									indexSID = i;
								}
							}
							
							if (!sid.equals(students[indexSID].getId()))
								System.out.println("\tThere is no such a SID!");
							
						} while (!validSID);
						
						
						boolean validCID = false;
						int indexCID = 0;
						
						// takes valid Course ID
						do{
							System.out.print("CID: ");
							cid = input2.nextLine();
							for (int i = 0; i < courses.length; i++) 
							{
								if (cid.equals(courses[i].getCid()))
								{
									validCID = true;
									indexCID = i;
								}
							}
							
							if (!cid.equals(courses[indexCID].getCid()))
								System.out.println("\tThere is no such a CID!");
							
						} while (!validCID);
						
						// set chosen course to chosen student in the "expanded takenCourses" matrix and display it
						takenCourses = Arrays.copyOf(takenCourses, takenCourses.length + 1);
						takenCourses[takenCourses.length - 1] = new TakeCourse(students[indexSID],courses[indexCID]);
						System.out.println(students[indexSID].getName() + " takes " + courses[indexCID].getDescription() + " course");
						takenCourses[takenCourses.length - 1].display();
						
						break;
						
				case 7: validSID = false;
						indexSID = 0;
						
						// takes valid Student ID
						do{
							System.out.print("SID: ");
							sid = input2.nextLine();
							
							for (int i = 0; i < students.length; i++) 
							{
								if (sid.equals(students[i].getId()))
								{
									validSID = true;
									indexSID = i;
								}
							}
							
							if (!sid.equals(students[indexSID].getId()))
								System.out.println("\tThere is no such a SID!");
							
						} while (!validSID);
						
						
						int indexOfTakenCourses = 0, count = 0;
						
						// checks and counts how many courses takes that student
						for (int i = 0; i < takenCourses.length; i++) 
						{
							if (students[indexSID].equals(takenCourses[i].getStudent()))
								count++;
						}
						
						int[] coursesTakenByStudent = new int[count];
						count = 0;
						
						// finds in which position are they in "takenCourses" matrix
						for (int i = 0; i < takenCourses.length; i++) 
						{
							if (students[indexSID].equals(takenCourses[i].getStudent()))
								coursesTakenByStudent[count++] = i;
						}
						
						validCID = false;
						
						// takes the Course ID that belongs to that student
						do{
							System.out.print("CID: ");
							cid = input2.nextLine();
						
							for (int i = 0; i < coursesTakenByStudent.length; i++) 
							{
								if (cid.equals(takenCourses[coursesTakenByStudent[i]].getCourse().getCid()))
								{
									validCID = true;
									indexOfTakenCourses = coursesTakenByStudent[i];
									break;
								}
							}
							
							if (!validCID)
								System.out.println("\tIt's not the course that " + students[indexSID].getName() + " takes!");
							
						} while (!validCID);
						
						System.out.println(students[indexSID].getName() + " gave up taking " + takenCourses[indexOfTakenCourses].getCourse().getDescription() + " course");
						
						// empty object to hold another object
						TakeCourse tempObj = new TakeCourse();
						
						// changes places with last one in "takenCourses" matrix to remove easier
						tempObj = takenCourses[takenCourses.length - 1];
						takenCourses[takenCourses.length - 1] = takenCourses[indexOfTakenCourses];
						takenCourses[indexOfTakenCourses] = tempObj;
						
						// by shrinking the "takenCourses" array it removes the last one
						takenCourses = Arrays.copyOf(takenCourses, takenCourses.length - 1);
						
						break;
						
				case 8: int subSelection;
						
						do{
							// empty space before hyphen
							for (int i = 0; i < 6; i++) 
							{
								System.out.print(" ");
							}
							
							// hyphen
							for (int i = 0; i < 85; i++) 
							{
								System.out.print("-");
							}
							System.out.println();
							// end of hyphen
							
							String[] searchMenu = {"1-Gives student inforamtion","2-Which course is taken by students","3-Gives course information","4-Which student takes which course","5-Exit"};
							
							System.out.printf("\t%-45s",searchMenu[0]);
							System.out.printf("%s\n",searchMenu[2]);
							System.out.printf("\t%-45s",searchMenu[1]);
							System.out.printf("%s\n",searchMenu[3]);
							System.out.printf("%-45s%s\n","",searchMenu[4]);
							
							// empty space before hyphen
							for (int i = 0; i < 6; i++) 
							{
								System.out.print(" ");
							}
							
							// hyphen
							for (int i = 0; i < 85; i++) 
							{
								System.out.print("-");
							}
							System.out.println();
							// end of hyphen
							
							System.out.printf("%-4sSubSelection: ","");
							subSelection = input1.nextInt();
							
							switch (subSelection)
							{
								case 1: boolean validName = false;
										indexSID = 0;
										
										do{
											System.out.printf("%-4sName: ","");
											name = input2.nextLine();
											
											for (int i = 0; i < students.length; i++) 
											{
												if (name.equals(students[i].getName()))
												{
													validName = true;
													indexSID = i;
												}
											}
											
											if (!validName)
												System.out.println("\t\tThere is no such a student!");
											
										} while (!validName);
										
										System.out.printf("\n%-4s----- Following information is about " + name + " -----\n\n","");
										System.out.println("\tID: " + students[indexSID].getId());
										System.out.println("\tName: " + students[indexSID].getName());
										System.out.println("\tDepartment: " + students[indexSID].getDepartment());
										System.out.println("\tEmail: " + students[indexSID].getEmail() + "\n");
										
										break;
										
								case 2: validCID = false;
										indexCID = 0;
										count = 0;
										
										do{
											System.out.printf("%-4sCID: ","");
											cid = input2.nextLine();
											
											for (int i = 0; i < takenCourses.length; i++) 
											{
												if (cid.equals(takenCourses[i].getCourse().getCid()))
												{
													validCID = true;
													indexCID = i;
												}
											}
											
											if (!validCID)
												System.out.println("\t\tThere is no such a course or nobody takes this course!");
											
										} while (!validCID);
										
										// counts how many students take this course
										for (int i = 0; i < takenCourses.length; i++) 
										{
											if (cid.equals(takenCourses[i].getCourse().getCid()))
												count++;
										}
										
										coursesTakenByStudent = new int[count];
										count = 0;
										
										// finds in which position are they in "takenCourses" matrix
										for (int i = 0; i < takenCourses.length; i++) 
										{
											if (cid.equals(takenCourses[i].getCourse().getCid()))
												coursesTakenByStudent[count++] = i;
										}
										
										System.out.printf("\n%-4s----- " + takenCourses[indexCID].getCourse().getCid() + " " + takenCourses[indexCID].getCourse().getDescription() + " course is taken by following students -----\n\n","");
										
										for (int i = 0; i < coursesTakenByStudent.length; i++) 
										{
											System.out.printf("%-4s","");
											takenCourses[coursesTakenByStudent[i]].display();
										}
										System.out.println();
										
										break;
										
								case 3: validCID = false;
										indexCID = 0;
										
										do{
											System.out.printf("%-4sCID: ","");
											cid = input2.nextLine();
											
											for (int i = 0; i < students.length; i++) 
											{
												if (cid.equals(courses[i].getCid()))
												{
													validCID = true;
													indexCID = i;
												}
											}
											
											if (!validCID)
												System.out.println("\t\tThere is no such a course!");
											
										} while (!validCID);
										
										System.out.printf("\n%-4s----- Following information is about " + cid + " Course -----\n\n","");
										System.out.println("\tCID: " + courses[indexCID].getCid());
										System.out.println("\tCourse Description: " + courses[indexCID].getDescription());
										System.out.println("\tMidterm1: " + courses[indexCID].getEval()[0]);
										System.out.println("\tMidterm2: " + courses[indexCID].getEval()[1]);
										System.out.println("\tFinal: " + courses[indexCID].getEval()[2] + "\n");
										
										break;
										
								case 4: validSID = false;
										indexSID = 0;
										count = 0;
										
										do{
											System.out.printf("%-4sSID: ","");
											sid = input2.nextLine();
											
											for (int i = 0; i < takenCourses.length; i++) 
											{
												if (sid.equals(takenCourses[i].getStudent().getId()))
												{
													validSID = true;
													indexSID = i;
												}
											}
											
											if (!validSID)
												System.out.println("\t\tThere is no such a student or this student doesn't take any course!");
											
										} while (!validSID);
										
										// counts how many courses takes this student
										for (int i = 0; i < takenCourses.length; i++) 
										{
											if (sid.equals(takenCourses[i].getStudent().getId()))
												count++;
										}
										
										coursesTakenByStudent = new int[count];
										count = 0;
										
										// finds in which position are they in "takenCourses" matrix
										for (int i = 0; i < takenCourses.length; i++) 
										{
											if (sid.equals(takenCourses[i].getStudent().getId()))
												coursesTakenByStudent[count++] = i;
										}
										
										System.out.printf("\n%-4s----- " + takenCourses[indexSID].getStudent().getName() + " takes following courses -----\n\n","");
										
										for (int i = 0; i < coursesTakenByStudent.length; i++) 
										{
											System.out.printf("%-4s","");
											takenCourses[coursesTakenByStudent[i]].display();
										}
										System.out.println();
										
										break;
										
							} // end of second (subselection) switch
							
						} while (subSelection != 5);
						
						break;
						
			} // end of first (selection) switch
			
		} while (selection != -1);
		
		
		System.out.println("\n");
		for (int i = 0; i < 103; i++) 
		{
			System.out.print("*");
		}
		
		System.out.print("\nDear Advisor,\nWould you like to send an e-mail to students (Y/N): ");
		char choice = input2.nextLine().charAt(0);
		
		if (choice == 'Y' || choice == 'y')
		{
			System.out.print("Identify : admin@fatih.edu.tr\nTo: ");
			
			for (int i = 0; i < students.length; i++) 
			{
				System.out.print(students[i].getName());
				
				// goes to new line after certain strings
				if (i % 2 == 0 && i != 0) 
					System.out.println();
				
				System.out.print(" <" + students[i].getEmail() + ">, ");
			}
			
			System.out.println("\nSubject: Course Registration \nText:");
			
			String text = "Dear students, \n\tTips for a successful registration\n" +
			"\t* Get prepped. Learn about advising, selecting courses, registration bars, and more in before \n\t  registering.\n" +
			"\t* Use waitlists to help you automatically register for a full class if other students drop out, \n\t  or the department adds seats. Learn more about waitlists.\n" +
			"\t* If you miss registering at your first opportunity, learn about registering late.\n" +
			"\t* Learn what to do after registering, including paying your tuition and changing your schedule.\n" +
			"\t* Don’t need class credit? Attend as an auditor. Learn more about auditing classes.\n";
			
			System.out.println(text);
			StringOperation string = new StringOperation(text);
			
			System.out.print("\tWould you like to know information about your text (Y/N): ");
			choice = input2.nextLine().charAt(0);
			
			if (choice == 'Y' || choice == 'y')
			{
				System.out.printf("\n\tYour program consists of " + string.countWord() + " words and " + string.countSentence() + " sentences. ");
				if (string.isDigit())
					System.out.println("There is a digit.\n");
				else
					System.out.println("There is no digit.\n");
			}
			
			do{
				System.out.print("\tWould you like to make changes in your text before sending email (Y/N): ");
				choice = input2.nextLine().charAt(0);
				
				if (choice == 'Y' || choice == 'y')
				{
					do{
						System.out.print("\t");
						
						// hyphen
						for (int i = 0; i < 90; i++) 
						{
							System.out.print("-");
						}
						System.out.print("\n\t\t\t");
						// end of hyphen
						
						String[] textMenu = {"1-Add","2-Delete","3-Update","4-Search","5-List","6-Exit"};
						
						for (int i = 0; i < textMenu.length; i++) 
						{
							System.out.printf("%-10s",textMenu[i]);
						}
						System.out.println();
						
						System.out.print("\t");
						
						// hyphen
						for (int i = 0; i < 90; i++) 
						{
							System.out.print("-");
						}
						System.out.println();
						// end of hyphen
						
						
						System.out.print("\tSelection: ");
						selection = input1.nextInt();
						
						switch (selection)
						{
							case 1: System.out.print("\tEnter your text: ");
									String newText = input2.nextLine();
									
									string.addString("\t" + newText);
									break;
									
							case 2: System.out.print("\tEnter word: ");
									newText = input2.nextLine();
									
									string.deleteString(newText);
									System.out.println("\t" + newText + " is deleted.");
									break;
									
							case 3: System.out.print("\tEnter word: ");
									String word1 = input2.nextLine();
									
									System.out.print("\tNew word: ");
									String word2 = input2.nextLine();
									
									string.updateString(word1, word2);
									System.out.println("\tYour text is updated.");
									break;
									
							case 4: System.out.print("\tEnter word: ");
									word1 = input2.nextLine();
									
									System.out.println("\tFollowing sentences contain " + word1 + " words");
									
									System.out.print("\t\t\t\t");
									for (int i = 0; i < 40; i++) 
									{
										System.out.print("-");
									}
									
									string.searchString(word1);
									
									System.out.print("\t\t\t\t");
									for (int i = 0; i < 40; i++) 
									{
										System.out.print("-");
									}
									System.out.println();
									
									break;
									
							case 5: System.out.println("Your new text:");
							
									System.out.print("\t\t\t");
									for (int i = 0; i < 60; i++) 
									{
										System.out.print("-");
									}
									System.out.println();
									
									string.listString();
									
									System.out.print("\t\t\t");
									for (int i = 0; i < 60; i++) 
									{
										System.out.print("-");
									}
									System.out.println();
									
									break;
						}
						
					} while (selection != 6);
				}
				
				else if (choice != 'N' || choice != 'n') break;
				
			} while (choice != 'N' || choice != 'n');
			
		}
		
		System.out.print("\tWould you like to send your mail: ");
		choice = input2.nextLine().charAt(0);
		
		if (choice == 'Y' || choice == 'y')
			System.out.println("Your mail was sent successfully ^_^");
		
		input1.close();
		input2.close();
	}

}

