package com.example.hrms.api;


import com.example.hrms.business.abstracts.PositionService;
import com.example.hrms.core.results.DataResult;
import com.example.hrms.core.results.Result;
import com.example.hrms.entities.concretes.Positions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Controller
@RequestMapping("/positions")
public class PositionsController {
   private PositionService positionService;

   @Autowired
   public PositionsController(PositionService positionService) {
       this.positionService = positionService;
   }

   @GetMapping("/getAll")
   public DataResult<List<Positions>> getByPositionList(){
       return positionService.getByPositionList();
   }

   @PostMapping("/add")
   public Result getByPositionSave(@RequestBody Positions positions){
       return positionService.getByPositionSave(positions);
   }

   @DeleteMapping("/delete{positionName}")
   public Result getByPositionDelete(@PathVariable String positionName){
       return positionService.getByPositionDelete(positionName);
   }


}
