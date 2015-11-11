package cc.lottery.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import cc.lottery.Hopper;

@Controller
@RequestMapping("play.do")
@SessionAttributes("winningHistory")
public class LotteryController
{
    
    @ModelAttribute("winningHistory") 
    public List<Integer[]> init() {
      
        ArrayList<Integer[]> newlist= new ArrayList<Integer[]>();
        return newlist;
    }
    
    @RequestMapping
    public ModelAndView simulateLottery(
        @ModelAttribute("winningHistory") ArrayList<Integer[]> winningHistory,
        @RequestParam("num1") int num1,
        @RequestParam("num2") int num2,
        @RequestParam("num3") int num3,
        @RequestParam("num4") int num4,
        @RequestParam("num5") int num5,
        @RequestParam("num6") int num6
                                        ) {
        
        Hopper hopper = new Hopper();
        Integer[] winningNum = hopper.getWinner ();
        int [] selectedNums= {num1, num2 ,num3,num4, num5, num6};
        
        
        
        winningHistory.add (winningNum);
        
        
        
        int match=0;
        for (int selected : selectedNums)
        {
            for (int winnings  : winningNum)
            {
                if (selected == winnings ){
                    match++;
                }
                   
            }
        }
        ModelAndView mv = new ModelAndView ();
        mv.setViewName ("play.jsp");
        mv.addObject ("yourpicks", selectedNums);
        mv.addObject ("winningnumbers", winningNum);
        
        return mv;
    }
}
