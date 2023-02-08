import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(
    home: SafeArea(child: Scaffold(
      body: QuizPage(),
    )),
  ));
}
class Questions{
  final bool answer;
  final String question;
  Questions({required this.question, required this.answer});
}
class Question{
  List<Questions> questionBank = [
    Questions(question: "Rainbow has 10 colours", answer: false),
    Questions(question: "Rainbow has 10 colours", answer: false),
    Questions(question: "Rainbow has 10 colours", answer: false),
    Questions(question: "Rainbow has 10 colours", answer: false),
    Questions(question: "Rainbow has 10 colours", answer: false),
  ];
}
class QuizPage extends StatefulWidget {
  const QuizPage({Key? key}) : super(key: key);

  @override
  State<QuizPage> createState() => _QuizPageState();
}

class _QuizPageState extends State<QuizPage> {
  int questionNumber=0;
  int currentScore=0;
  Question question=Question();
  void updateQuestionNumber(){
    setState(() {
      questionNumber=questionNumber+1;
      print('$questionNumber');
    });
  }
  void updateCurrentScore(bool choice,int question_number){
    if(question.questionBank.length == question_number){
      print('End of questions');
    }
    else{
      if(question.questionBank[question_number].answer==choice){
        setState(() {
          currentScore++;
        });
      }
    }
  }
  bool checkQuestionNumber(int questionNumber){
    return questionNumber<question.questionBank.length?true:false;
  }
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Column(children: [
        Center(
          child: Text(
            checkQuestionNumber(questionNumber)?question.questionBank[questionNumber].question.toString() : "End",
            style: TextStyle(fontSize: 40.0),
          ),
        ),
        SizedBox(height: 20.0),
        if(checkQuestionNumber(questionNumber))
          ElevatedButton(onPressed: (){
            setState(() {
              if(questionNumber==question.questionBank.length){
                print("End of questions");
              }else{
                updateCurrentScore(true, questionNumber);
                updateQuestionNumber();
              }
            });
          }, child: Text('True'),),
         SizedBox(width: 20.0),
        if (checkQuestionNumber(questionNumber))
          ElevatedButton(onPressed: (){
            setState(() {
              if(questionNumber==question.questionBank.length){
                print("End of questions");
              }
            });
          }, child: Text('False'),),
        SizedBox(
          height: 50.0,
        ),
        Padding(padding: const EdgeInsets.all(30.0),child:
          Center(
            child: Text("Current Score is : ", style: TextStyle(fontSize: 30),),
          ),),
        Padding(padding: const EdgeInsets.all(30.0),child:
          Center(child: Text('${currentScore}',style: TextStyle(fontSize: 30),),),)
      ],),
    );
  }
}


