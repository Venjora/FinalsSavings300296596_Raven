package samplePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@SessionAttributes({"id","desc","errMsg","ans"})
@Controller
public class InventoryController {


    SavingService service;

    @Autowired
    Connection123 connect;


    //a mapping when someone enters file
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSavingsPage(ModelMap model,@RequestParam(defaultValue = "") int custno) throws ClassNotFoundException, SQLException {


        service = new SavingService(connect.connect());

        model.addAttribute("todos", service.display());


        List<Savings> filteredTodos = new ArrayList<Savings>();

        filteredTodos = (List) model.get("todos");

        model.put("custno",filteredTodos.get(0).getCustno());


        model.put("custname",filteredTodos.get(0).getCustname());
        model.put("cdep",filteredTodos.get(0).getCdep());
        model.put("nyears",filteredTodos.get(0).getNyears());
        model.put("savtype",filteredTodos.get(0).getSavtype());


        return "index";

    }


//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String showCategoryPage2(ModelMap model) throws ClassNotFoundException, SQLException {
//
//        service1 = new DatabaseService(connect.connect());
//
//
//
//        model.addAttribute("todos", service1.display());
//
//
//        List<Category> filteredTodos = new ArrayList<Category>();
//
//        filteredTodos = (List) model.get("todos");
//
//        model.put("id",filteredTodos.get(0).getCatcode());
//
//
//
//        model.put("desc",filteredTodos.get(0).getCatdesc());
//
//
//        return "category";
//
//
//    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "addSaving";
    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam int custno, @RequestParam String custname) throws SQLException, ClassNotFoundException {


        if (!((service.search(custno)) ==null)){

            model.put("errorMessage","Record Exists");
            return "redirect:/index";

        }


        Savings cc = new Savings(custno,custname);

        service.add(cc);

        model.clear();
        return "redirect:/index";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") int custno) throws SQLException, ClassNotFoundException {

        model.put("custno", custno);


        Savings save =  service.search(custno);


        model.put("custno",save.getCustno());
        model.put("custname", save.getCustname());



        return "editSave";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,  @RequestParam int custno, @RequestParam String custname) throws SQLException, ClassNotFoundException {

        //get the old catcode

        int iid = (int) model.get("custno");

        Savings save= new Savings(custno,custname);

        service.edit(save,iid);

        return "redirect:/";

    }



    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {


        service.delete(id);


        model.clear();
        return "redirect:/";
    }



    @RequestMapping(value ="/see-todo", method = RequestMethod.POST)
    public String seetodo2(ModelMap model) throws SQLException, ClassNotFoundException {


        return "redirect:/";
    }


}