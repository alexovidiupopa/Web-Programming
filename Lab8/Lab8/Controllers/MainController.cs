using Lab8.Data_Abstraction_Layer;
using Lab8.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Lab8.Controllers
{
    public class MainController : Controller
    {
        public ActionResult Index()
        {
            return View("GetReports");
        }

        public string TestController()
        {
            return "Testing the MainController .. OK!";
        }



        public ActionResult GetReports()
        {
            DAL dal = new DAL();
            List<LogReport> slist = dal.GetLogReports();
            ViewData["reports"] = slist;
            return View("ViewGetReports");
        }

        public ActionResult AddStudent()
        {
            return View("AddNewStudent");
        }

        public ActionResult SaveReport()
        {
            LogReport log = new LogReport();
            log.User_id = int.Parse(Request.Params["user_id"]);
            log.Date = Request.Params["date"];
            log.Severity = Request.Params["severity"];
            log.Type = Request.Params["type"];
            DAL dal = new DAL();
            dal.AddLogReport(log);
            return RedirectToAction("GetReports");
        }

        public string GetReportsOfType()
        {
            string type =(Request.Params["type"]);
            DAL dal = new DAL();
            List<LogReport> slist = dal.GetReportsOfType(type);
            ViewData["reports"] = slist;

            string result = "<table><thead><th>Id</th><th>User_id</th><th>Type</th><th>Severity</th></thead>";

            foreach (LogReport stud in slist)
            {
                result += "<tr><td>" + stud.Id + "</td><td>" + stud.User_id + "</td><td>" + stud.Type + "</td><td>" + stud.Severity + "</td><td></tr>";
            }

            result += "</table>";
            return result;
        }
    }
}