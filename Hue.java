PFont font;  // Font for the text
int fontSize = 32;  // Font size
float textX, textY;  // Position of the text

// Buttons
Button back;
Button easyButton;
Button goalEasy;
Button mediumButton;
Button goalMedium;
Button hardButton;
Button goalHard;
Button gameOver;

// global variables
String currentLevel = "home";
ArrayList<Integer> usedColors = new ArrayList<Integer>();
int circleSize = 10;
color oldBlackcolor;
int iBlack;
int jBlack;
boolean isBlacktile = false;
int count = 0;
boolean buttonEnabled = true;


// esay class variables
color[][] randomColorGrid1;
int tilesY1 = 13;
int tilesX1 = 10;
int tileSizeX1 = 540/tilesX1;
int tileSizeY1 = 720/tilesY1;
int offsetX1 = tileSizeX1/2;
int offsetY1 = tileSizeY1/2;
color[][] gridColor1 = new color[tilesY1][tilesX1];

// medium class variables
color[][] randomColorGrid2;
int tilesX2 = 9;
int tilesY2 = 11;
int tileSizeX2 = 540/tilesX2;
int tileSizeY2 = 720/tilesY2;
int offsetX2 = tileSizeX2/2;
int offsetY2 = tileSizeY2/2;
color[][] gridColor2 = new color[tilesY2][tilesX2];

// hard class variables
color[][] randomColorGrid3;
int tilesX3 = 11;
int tilesY3 = 10;
int tileSizeX3 = 540/tilesX3;
int tileSizeY3 = 720/tilesY3;
int offsetX3 = tileSizeX3/2;
int offsetY3 = tileSizeY3/2;
color[][] gridColor3 = new color[tilesY3][tilesX3];

void setup() {
  size(540, 720);
  font = createFont("Monaco", fontSize);
  textFont(font);
  
  // buttons
  back = new Button (width - 26, height - 18, "Back");
  easyButton = new Button(width/4, height/2, "Easy");
  goalEasy = new Button (width/4, 3*height/4, "Easy Goal");
  mediumButton = new Button(width/2, height/2, "Medium");
  goalMedium = new Button (width/2, 3*height/4, "Medium Goal");
  hardButton = new Button(3*width/4, height/2, "Hard");
  goalHard = new Button (3*width/4, 3*height/4, "Hard Goal");
  gameOver = new Button(width/2, height/2, "Game Over");
  
  // Set initial position of the text
  textY = height/6;
  textX = width/2;
  
  //easy setup
    randomColorGrid1 = new color[][] { {#5D2AE5, #6D2EDD, #7E34C3, #9238BB, #9F3FAA, #B3459E, #C44B90, #D84E81, #E95171, #E9535D},
                           {#5A37E0, #693DD2, #7C42C4, #8E47B7, #9F4CA8, #B25199, #C3558C, #D55A7D, #E36070, #E45F5C},
                           {#5749DE, #694BD1, #7A50C3, #8C55B3, #9C57A5, #AE5D97, #C26089, #D3657B, #E6696D, #E86759},
                           {#5255E1, #645AD7, #775DC1, #8A61B2, #9D65A5, #AE6896, #BC6E85, #D36F77, #E57368, #EF6C56},
                           {#5162D7, #6268CD, #746BBC, #886EB0, #9B71A1, #AC7390, #BF7783, #CF7972, #E47D66, #E87A53},
                           {#4E74D8, #6076CB, #7377BA, #877BAD, #997D9D, #AC7E90, #BD827F, #D28472, #E38761, #E4804D},
                           {#4884DA, #5C86C9, #6F87BC, #8488AA, #96899C, #A98B8B, #BD8C7C, #CF8E6E, #E29060, #E68747},
                           {#4792D4, #5A92C5, #6E94B5, #8294A6, #949597, #A89688, #B9987D, #CC986A, #E2995C, #E7963B},
                           {#46A0D4, #58A0C5, #6BA1B3, #80A2A4, #92A297, #A5A286, #BAA476, #CDA467, #DFA458, #E59D42},
                           {#42AFD0, #55AFC0, #69AFB2, #7EADA2, #91AE92, #A5AE82, #B8AE73, #CDAF64, #DFAD55, #E5A340},
                           {#42BCD2, #53BDC0, #68BCB0, #7DBB9F, #8EBC90, #A4BB80, #B7B971, #CCB860, #DEB750, #E0AF3C},
                           {#3ACECD, #51CCBD, #65CBAF, #79C99C, #8DC78D, #A1C57D, #B6C46C, #C9C25E, #DFC14F, #E5B43C},
                           {#3ADBCA, #4ED9BA, #66D9AE, #78D59C, #8DD28D, #A0D27B, #B5CF6A, #C6CA5A, #DDCB4B, #E5BF35},
    };
  for (int i = 0; i < tilesY1; i++) {
      for (int j = 0; j < tilesX1; j++) {
        if(j%2 != 0){
          int randomIndex = (int) (Math.random()*randomColorGrid1[i].length);
          
          // Generate random color
          int randomColor = randomColorGrid1[i][randomIndex];
          
          // Check if color has been used before
          while (usedColors.contains(randomColor)) {
          randomIndex = (int) (Math.random()*randomColorGrid1[i].length);
          randomColor = randomColorGrid1[i][randomIndex];
          }
          
          usedColors.add(randomColor);
          gridColor1[i][j] = randomColor;
          
        } else {
            int regColor = randomColorGrid1[i][j];
            usedColors.add(regColor);
            gridColor1[i][j] = regColor;
        }
      }
   } 
   
   //medium setup
   usedColors.clear();
   randomColorGrid2 = new color[][] {{#C5C1BF, #C6C7C1, #C9CDC6, #CBD5CA, #CDDACE, #CFE3D2, #D2E9D7, #D3EFDA, #D7F8DE},
                           {#BEBBC2, #C1C2C5, #C3C7C9, #C6CECD, #C9D2D1, #CBD9D6, #CFE0D8, #D2E6DD, #D4EDE2},
                           {#B6B8C4, #B9BCC8, #BDC2CD, #C1C6D0, #C4CDD5, #C8D1D7, #CBD6DB, #CEDCDF, #D2E1E2},
                           {#B0B4C8, #B4B8CC, #B8BBD0, #BBC0D3, #BFC4D7, #C4CADA, #C8CEDE, #CCD2E2, #D0D6E4},
                           {#A9B0CD, #ADB2CF, #B2B7D5, #B7B9D6, #BCBEDB, #C0C0DE, #C5C4E0, #C9C8E4, #CECCE7},
                           {#A2ABD2, #A7ADD4, #ACB1D6, #B1B2D9, #B9B6DE, #BDB9E1, #C3BCE3, #C8BFE7, #CEC2EB},
                           {#9CA7D5, #A1A9D8, #A6ABD9, #ADADDD, #B3AEE0, #B9B1E4, #BEB2E7, #C6B5E9, #CCB6EE},
                           {#95A3D4, #9AA4DA, #A1A4DC, #A8A6E0, #AEA7E3, #B5A8E6, #BBA9E9, #C3A9EC, #CAA9F3},
                           {#8EA0DC, #949EDF, #9B9FE1, #A3A0E4, #AAA0E7, #B2A0E9, #B9A0EC, #C1A1EF, #C8A1F2},
                           {#869BDF, #8E9AE2, #969AE5, #9D99E7, #A699EA, #AF98ED, #B898F0, #BE97F2, #C897F5},
                           {#7F98E2, #8795E5, #9094E8, #9892EA, #A191ED, #AB8FEF, #B48DF3, #BE97F2, #C58CFD},
   };
   for (int i = 0; i < tilesY2; i++) {
      for (int j = 0; j < tilesX2; j++) {
        if(j != 0 && j != tilesX2 - 1){
          int randomIndex = (int) (Math.random()*randomColorGrid2[i].length);
          
          // Generate random color
          int randomColor = randomColorGrid2[i][randomIndex];
          
          // Check if color has been used before
          while (usedColors.contains(randomColor)) {
          randomIndex = (int) (Math.random()*randomColorGrid2[i].length);
          randomColor = randomColorGrid2[i][randomIndex];
          }
          usedColors.add(randomColor);
          gridColor2[i][j] = randomColor;
          
          } else {
              int regColor = randomColorGrid2[i][j];
              usedColors.add(regColor);
              gridColor2[i][j] = regColor;
          }
          fill(randomColorGrid2[i][j]);
          rect(j*tileSizeX2 + offsetX2, i*tileSizeY2 + offsetY2, tileSizeX2, tileSizeY2);
      }
    }
    
    // hard setup
    usedColors.clear();
    randomColorGrid3 = new color[][] { {#A7C8AB, #A1C9B1, #9CC6B8, #9AC7C0, #96C3C1, #99C7CC, #A4CCCC, #AFD0CF, #B7D4D0, #BFD6D2, #C0D4D0},
                           {#94C3B0, #90C2B7, #8DC2BE, #8BC1C3, #8AC2C9, #8BC3D0, #9AC8D1, #A6CDD4, #B0D1D7, #B9D5D7, #B9CDCE},
                           {#82BDB5, #81BDBD, #7DBCC3, #7EBECA, #7EBCCD, #82C0D7, #8EC4D6, #9DCAD9, #A7CDD9, #B1D2DB, #B4CFD7},
                           {#6FB7BB, #6FB7C3, #6EB8C9, #6EB9CD, #6FB8D4, #72B9D7, #84C2DA, #91C6DC, #9EC9DC, #ABD1E0, #AECEDB},
                           {#5EB1C1, #5DB2C7, #5FB3CF, #61B5D5, #65B7DB, #67B5DF, #77BDE1, #89C5E3, #97C9E4, #A4CEE5, #A9CADD},
                           {#4BACC8, #4CAECD, #4DADD1, #52B0DB, #56AFDC, #5BB4E3, #6EBBE7, #7EC0E7, #8CC5E6, #9CCCE9, #A8D0EA},
                           {#3AA5CE, #3CA7D3, #3EA7D6, #43ABDE, #49ACE3, #50B1EB, #64B8EC, #76BEEC, #86C3ED, #96CAEF, #A3CBEE},
                           {#28A0D2, #2AA1D7, #2FA4DD, #36A7E5, #3CABEA, #46ADF1, #5AB4F2, #6CBCF1, #7DC0F1, #8EC7F2, #9BCAEF},
                           {#169BD8, #1B9CDF, #209FE5, #27A2EB, #2FA6F0, #39A8F3, #4EB1F5, #64B8F5, #76BFF7, #88C5F9, #93C4F2},
                           {#0496DD, #0A96E3, #109AEA, #189DEF, #22A0F4, #2CA3F6, #44AEFB, #57B5FA, #6DBBFA, #80C3FD, #8FC5F7},
   };
   for (int i = 0; i < tilesY3; i++) {
      for (int j = 0; j < tilesX3; j++) {
        if (!((i == 0 && j == 0) || (i == 0 && j == tilesX3 - 1) || (i == tilesY3 - 1 && j == 0) || (i == tilesY3 - 1 && j == tilesX3 - 1))) {
          int randomIndex = (int) (Math.random()*randomColorGrid3[i].length);
          
          // Generate random color
          int randomColor = randomColorGrid3[i][randomIndex];
          
          // Check if color has been used before
          while (usedColors.contains(randomColor)) {
          randomIndex = (int) (Math.random()*randomColorGrid3[i].length);
          randomColor = randomColorGrid3[i][randomIndex];
          }
          usedColors.add(randomColor);
          gridColor3[i][j] = randomColor;
          
          } else {
              int regColor = randomColorGrid3[i][j];
              usedColors.add(regColor);
              gridColor3[i][j] = regColor;
          }
          fill(randomColorGrid3[i][j]);
          rect(j*tileSizeX3 + offsetX3, i*tileSizeY3 + offsetY3, tileSizeX3, tileSizeY3);
      }
    }
}
boolean isSolved(String level){
    if (level.equals("easy")){
    for (int i = 0; i < tilesY1; i++) {
          for (int j = 0; j < tilesX1; j++) {
            if (randomColorGrid1[i][j] != gridColor1[i][j]){
              return false;
            } 
          }
        }
    } else if (level.equals("medium")){
    for (int i = 0; i < tilesY2; i++) {
          for (int j = 0; j < tilesX2; j++) {
            if (randomColorGrid2[i][j] != gridColor2[i][j]){
              return false;
            } 
          }
        }
    } else if (level.equals("hard")){
      for (int i = 0; i < tilesY3; i++) {
          for (int j = 0; j < tilesX3; j++) {
            if (randomColorGrid3[i][j] != gridColor3[i][j]){
              return false;
            } 
          }
        }  
    }
    return true;
  }


void draw() {
    if (currentLevel.equals("home")) {
        background(0); // Black background

        // Display animated colorful text
        fill(random(255), random(255), random(255));
        textSize(fontSize);
        textAlign(CENTER, CENTER);
        text("I Love Hue 2.0", textX, textY);

        // Display the buttons
        easyButton.display();
        goalEasy.display();
        mediumButton.display();
        goalMedium.display();
        hardButton.display();
        goalHard.display();
        System.out.println("test");
    }

    // Game Interfaces
    if (currentLevel.equals("easy")) {
        // Easy level interface
        for (int i = 0; i < tilesY1; i++) {
            for (int j = 0; j < tilesX1; j++) {
                fill(gridColor1[i][j]);
                rect(j * tileSizeX1 + offsetX1, i * tileSizeY1 + offsetY1, tileSizeX1, tileSizeY1);
            }
        }
        //mark guiding tiles
        for (int x = 0; x < tilesY1 * 2; x += 2) {
            for (int y = 0; y < tilesX1 * 2; y += 4) {
                fill(0);
                circle(tileSizeX1 * 0.5 * y + offsetX1, tileSizeY1 * 0.5 * x + offsetY1, circleSize);
            }
        }
        back.display2(); // return to home page

        if (isSolved("easy") == true && count > 1) {
            gameOver.display();
            exit();
        }
    } else if (currentLevel.equals("easyGoal")) {
        // Goal of level easy
        for (int i = 0; i < tilesY1; i++) {
            for (int j = 0; j < tilesX1; j++) {
                fill(randomColorGrid1[i][j]);
                rect(j * tileSizeX1 + offsetX1, i * tileSizeY1 + offsetY1, tileSizeX1, tileSizeY1);
            }
        }
        //mark guiding tiles
        for (int x = 0; x < tilesY1 * 2; x += 2) {
            for (int y = 0; y < tilesX1 * 2; y += 4) {
                fill(0);
                circle(tileSizeX1 * 0.5 * y + offsetX1, tileSizeY1 * 0.5 * x + offsetY1, circleSize);
            }
        }
        back.display2(); // return to home page

    } else if (currentLevel.equals("medium")) {
        // Medium level interface
        for (int i = 0; i < tilesY2; i++) {
            for (int j = 0; j < tilesX2; j++) {
                fill(gridColor2[i][j]);
                rect(j * tileSizeX2 + offsetX2, i * tileSizeY2 + offsetY2, tileSizeX2, tileSizeY2);
                //mark guiding tiles
                if (j == 0 || j == tilesX2 - 1) {
                    fill(0);
                    circle(tileSizeX2 * j + offsetX2, tileSizeY2 * i + offsetY2, circleSize);
                }
            }
        }
        back.display2(); // return to homepage
        if (isSolved("medium") == true) {
            gameOver.display();
            exit();
        }

    } else if (currentLevel.equals("mediumGoal")) {
        // Goal of level medium
        for (int i = 0; i < tilesY2; i++) {
            for (int j = 0; j < tilesX2; j++) {
                fill(randomColorGrid2[i][j]);
                rect(j * tileSizeX2 + offsetX2, i * tileSizeY2 + offsetY2, tileSizeX2, tileSizeY2);
                //mark guiding tiles
                if (j == 0 || j == tilesX2 - 1) {
                    fill(0);
                    circle(tileSizeX2 * j + offsetX2, tileSizeY2 * i + offsetY2, circleSize);
                }
            }
        }
        back.display2(); // return to home page

    } else if (currentLevel.equals("hard")) {
        // Hard level interface
        for (int i = 0; i < tilesY3; i++) {
            for (int j = 0; j < tilesX3; j++) {
                fill(gridColor3[i][j]);
                rect(j * tileSizeX3 + offsetX3, i * tileSizeY3 + offsetY3, tileSizeX3, tileSizeY3);
                //mark guiding tiles
                if ((i == 0 && j == 0) || (i == 0 && j == tilesX3 - 1) || (i == tilesY3 - 1 && j == 0) || (i == tilesY3 - 1 && j == tilesX3 - 1)) {
                    fill(0);
                    circle(tileSizeX3 * j + offsetX3, tileSizeY3 * i + offsetY3, circleSize);
                }
            }
        }
        back.display2(); // return to home page
        if (isSolved("hard") == true) {
            gameOver.display();
            exit();
        }

    } else if (currentLevel.equals("hardGoal")) {
        // Goal of level hard
        for (int i = 0; i < tilesY3; i++) {
            for (int j = 0; j < tilesX3; j++) {
                fill(randomColorGrid3[i][j]);
                rect(j * tileSizeX3 + offsetX3, i * tileSizeY3 + offsetY3, tileSizeX3, tileSizeY3);
                //mark guiding tiles
                if ((i == 0 && j == 0) || (i == 0 && j == tilesX3 - 1) || (i == tilesY3 - 1 && j == 0) || (i == tilesY3 - 1 && j == tilesX3 - 1)) {
                    fill(0);
                    circle(tileSizeX3 * j + offsetX3, tileSizeY3 * i + offsetY3, circleSize);
                }
            }
        }
        back.display2(); // return to home page
    }
}

void mouseClicked() {
    // Check if a button is clicked
    System.out.println("mousex is " + mouseX);
    System.out.println("tileSizeX3 is " + tileSizeX1);
    System.out.println("offsetX3 is " + offsetX1);
    System.out.println(mouseX / tileSizeX1);
    System.out.println(mouseY / tileSizeY1);
    if (easyButton.isClicked() && buttonEnabled == true) {
        currentLevel = "easy";
        buttonEnabled = false;

    } else if (back.isClicked()) {
        currentLevel = "home";
        buttonEnabled = true;

    } else if (goalEasy.isClicked() && buttonEnabled == true) {
        currentLevel = "easyGoal";
        buttonEnabled = false;

    } else if (mediumButton.isClicked() && buttonEnabled == true) {
        currentLevel = "medium";
        buttonEnabled = false;

    } else if (goalMedium.isClicked() && buttonEnabled == true) {
        currentLevel = "mediumGoal";
        buttonEnabled = false;

    } else if (hardButton.isClicked() && buttonEnabled == true) {
        currentLevel = "hard";
        buttonEnabled = false;

    } else if (goalHard.isClicked() && buttonEnabled == true) {
        currentLevel = "hardGoal";
        buttonEnabled = false;

    } else {
        if (currentLevel.equals("easy")) {
            if (mouseX / tileSizeX1 % 2 != 0) {
                if (isBlacktile == false) {
                    oldBlackcolor = gridColor1[mouseY / tileSizeY1][mouseX / tileSizeX1];
                    gridColor1[mouseY / tileSizeY1][mouseX / tileSizeX1] = 0;
                    isBlacktile = true;
                    iBlack = mouseY / tileSizeY1;
                    jBlack = mouseX / tileSizeX1;
                } else {
                    gridColor1[iBlack][jBlack] = gridColor1[mouseY / tileSizeY1][mouseX / tileSizeX1];
                    gridColor1[mouseY / tileSizeY1][mouseX / tileSizeX1] = oldBlackcolor;
                    isBlacktile = false;
                    count++;
                }
            }

        } else if (currentLevel.equals("medium")) {
            if (mouseX / tileSizeX2 != 0 && mouseX / tileSizeX2 != tilesX2 - 1) {
                if (isBlacktile == false) {
                    oldBlackcolor = gridColor2[mouseY / tileSizeY2][mouseX / tileSizeX2];
                    gridColor2[mouseY / tileSizeY2][mouseX / tileSizeX2] = 0;
                    isBlacktile = true;
                    iBlack = mouseY / tileSizeY2;
                    jBlack = mouseX / tileSizeX2;
                } else {
                    gridColor2[iBlack][jBlack] = gridColor2[mouseY / tileSizeY2][mouseX / tileSizeX2];
                    gridColor2[mouseY / tileSizeY2][mouseX / tileSizeX2] = oldBlackcolor;
                    isBlacktile = false;
                    count++;
                }
            }
        } else if (currentLevel.equals("hard")) {
            if (!((mouseY / tileSizeY3 == 0 && mouseX / tileSizeX3 == 0) || (mouseY / tileSizeY3 == 0 && mouseX / tileSizeX3 == tilesX3 - 1) || (mouseY / tileSizeY3 == tilesY3 - 1 && mouseX / tileSizeX3 == 0) || (mouseY / tileSizeY3 == tilesY3 - 1 && mouseX / tileSizeX3 == tilesX3 - 1))) {
                if (isBlacktile == false) {
                    oldBlackcolor = gridColor3[mouseY / tileSizeY3][mouseX / tileSizeX3];
                    gridColor3[mouseY / tileSizeY3][mouseX / tileSizeX3] = 0;
                    isBlacktile = true;
                    iBlack = mouseY / tileSizeY3;
                    jBlack = mouseX / tileSizeX3;
                } else {
                    gridColor3[iBlack][jBlack] = gridColor3[mouseY / tileSizeY3][mouseX / tileSizeX3];
                    gridColor3[mouseY / tileSizeY3][mouseX / tileSizeX3] = oldBlackcolor;
                    isBlacktile = false;
                    count++;
                }
            }
        }
    }
}


class Button {
    float x, y; // Position of the button
    float w = 100, h = 50; // Width and height of the button
    String label; // Text label for the button

    Button(float x, float y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    void display() {
        // Draw the button
        fill(255);
        rectMode(CENTER);
        rect(x, y, w, h);

        // Display the label
        fill(0);
        textSize(14);
        textAlign(CENTER, CENTER);
        text(label, x, y);
    }

    void display2() {
        // Draw the button
        fill(255);
        rectMode(CENTER);
        rect(x, y, 50, 25);

        // Display the label
        fill(0);
        textSize(9);
        textAlign(CENTER, CENTER);
        text(label, x, y);
    }

    boolean isClicked() {
        // Check if the button is clicked
        return mouseX >= x - w / 2 && mouseX <= x + w / 2 &&
            mouseY >= y - h / 2 && mouseY <= y + h / 2;
    }
}
