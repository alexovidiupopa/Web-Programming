using Lab8.Models;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Lab8.Data_Abstraction_Layer
{
    public class DAL
    {

        public MySqlConnection getConnection()
        {
            string myConnectionString;
            myConnectionString = "server=127.0.0.1;uid=alex;pwd=alex;database=logreports;";
            return new MySqlConnection(myConnectionString);
        
        } 

        public List<LogReport> GetLogReports()
        {         
            List<LogReport> slist = new List<LogReport>();
            try
            {
                MySqlConnection conn = getConnection();
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from LogReport" ;
                MySqlDataReader myreader = cmd.ExecuteReader();

                while (myreader.Read())
                {
                    LogReport report = new LogReport();
                    report.Id = myreader.GetInt32("id");
                    report.User_id = myreader.GetInt32("user_id");
                    report.Type = myreader.GetString("type");
                    report.Severity = myreader.GetString("severity");
                    report.Date = myreader.GetString("date");
                    slist.Add(report);
                }
                myreader.Close();

                conn.Close();
            }
            catch (MySqlException ex)
            {
                Console.Write(ex.Message);
            }
            return slist;
        }

        public void AddLogReport(LogReport log)
        {
            MySqlCommand cmd = new MySqlCommand();
            MySqlConnection conn = getConnection();
            conn.Open();
            cmd.Connection = conn;
            cmd.CommandText = "INSERT INTO LogReport(user_id, type, severity, date) VALUES (" +
                log.User_id + ", '" + log.Type + "', '" + log.Severity + "', '" + log.Date + "');";  
            cmd.ExecuteNonQuery();
        }

        public void DeleteLogReport(int id)
        {
            MySqlCommand cmd = new MySqlCommand();
            MySqlConnection conn = getConnection();
            conn.Open();
            cmd.Connection = conn;
            cmd.CommandText = "DELETE FROM LogReport WHERE id=" + id;
            cmd.ExecuteNonQuery();
        }

        public List<LogReport> GetReportsOfType(string type)
        {
            List<LogReport> slist = new List<LogReport>();
            try
            {
                MySqlConnection conn = getConnection();
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from LogReport where type='" + type + "'";
                MySqlDataReader myreader = cmd.ExecuteReader();

                while (myreader.Read())
                {
                    LogReport report = new LogReport();
                    report.Id = myreader.GetInt32("id");
                    report.User_id = myreader.GetInt32("user_id");
                    report.Type = myreader.GetString("type");
                    report.Severity = myreader.GetString("severity");
                    report.Date = myreader.GetString("date");
                    slist.Add(report);
                }
                myreader.Close();

                conn.Close();
            }
            catch (MySqlException ex)
            {
                Console.Write(ex.Message);
            }
            return slist;
        }

        public List<LogReport> GetReportsOfSeverity(string severity)
        {
            List<LogReport> slist = new List<LogReport>();
            try
            {
                MySqlConnection conn = getConnection();
                conn.Open();

                MySqlCommand cmd = new MySqlCommand();
                cmd.Connection = conn;
                cmd.CommandText = "select * from LogReport where severity='" + severity + "'";
                MySqlDataReader myreader = cmd.ExecuteReader();

                while (myreader.Read())
                {
                    LogReport report = new LogReport();
                    report.Id = myreader.GetInt32("id");
                    report.User_id = myreader.GetInt32("user_id");
                    report.Type = myreader.GetString("type");
                    report.Severity = myreader.GetString("severity");
                    report.Date = myreader.GetString("date");
                    slist.Add(report);
                }
                myreader.Close();

                conn.Close();
            }
            catch (MySqlException ex)
            {
                Console.Write(ex.Message);
            }
            return slist;
        }
    }
}