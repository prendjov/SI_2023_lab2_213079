# SI_2023_lab2_213079

## 2. Control Flow Graph
![SI_2023_Lab2_213079](https://github.com/prendjov/SI_2023_lab2_213079/assets/64280438/35c6e61f-a712-4973-92a4-970b4685af53)

## 3. Цикломатска комплексност  
Цикломатската комплексност на кодов е 11, која се добива со бројот на предикатни јазли во кодот (if услови).

## 4. Тест случаи според критериумот Every Branch
     Test Case 1: Mandatory Information Missing
        - Input: user = null
          Резултат: RuntimeException со пораката "Mandatory information missing!"
     Test Case 2: Email is invalid
        - Input: user = new User("username", "password", "invalidemail")
          Резултат: same = 1 (невалиден емаил)
     Test Case 3: Email е веќе искоритен или username е веќе искористен
        - Input: user = new User("existing", "password", "existingemail@example.com"), allUsers содржи User објекти со email "existingemail@example.com"
        - Резултат: same = 2 (email или username е веќе искористен)
     Test Case 4: Password contains username and length is less than 8
        - Input: user = new User("username", "password", "email@example.com")
          Резултат: false
     Test Case 5: Password contains special characters and email/username are unique
        - Input: user = new User("username", "password!", "email@example.com"), Каде password содржи специјален карактер
          Резултат: true
  
## 5. Тест случаи според критериумот Multiple Condition според if (user==null || user.getPassword()==null || user.getEmail()==null)
   ### Test case: user == null, сите други се занемруваат бидејќи првиот услов е точен
      user = null, user.getPassword()==null, user.getEmail()==null
   ### Test case: user.getPassword() == null, user != null
      user != null ,user = validUser (каде user.getPassword() е null)
   ### Test case: user.getEmail() == null, додека другите не се null
      user != null, user.getPassword() != null, user = validUser (каде user.getEmail() е null)
   ### Test case: Сите услови се неточни
      user = validUser (каде user, user.getPassword(), и user.getEmail() не се null)
