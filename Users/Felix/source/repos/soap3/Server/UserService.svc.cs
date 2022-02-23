using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.Data.SqlClient;

namespace Server
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "Service1" en el código, en svc y en el archivo de configuración.
    // NOTE: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione Service1.svc o Service1.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class Service1 : IUserService
    {
        public string addUser(User user)
        {
            if (user.username.Length<3 || user.email.Length<3)
            {
                return string.Format("Todos los campos son obligatorios");
            }
            else 
            {   
                
                SqlConnection sqlConnection = new SqlConnection("Data Source=DESKTOP-J7EBE14\\SQLEXPRESS;Initial Catalog=soap1;Integrated Security=True");
                sqlConnection.Open();

                string query = "select * from users where(email='"+user.email+"')";
                SqlCommand cmd = new SqlCommand(query, sqlConnection);
                cmd.ExecuteNonQuery();


                Int32 res =Convert.ToInt32(cmd.ExecuteScalar());
                if (res > 0)
                {
                       sqlConnection.Close();
                       return string.Format("El usuario ya se encuentra registrado");
                }
                else
                {

                    string query2 = "insert into users([username],[email]) values('" + user.username + "','" + user.email + "')";
                    SqlCommand cmd2 = new SqlCommand(query2, sqlConnection);
                    cmd2.ExecuteNonQuery();
                    sqlConnection.Close();
                    return string.Format("Usuario guardado exitosamente");

                }
                

            }

        }

        public List<User> getUsers()
        {
            SqlConnection sqlConnection = new SqlConnection("Data Source=DESKTOP-J7EBE14\\SQLEXPRESS;Initial Catalog=soap1;Integrated Security=True");
            sqlConnection.Open();
            string query = "select * from users";
            SqlCommand cmd = new SqlCommand(query, sqlConnection);
            SqlDataReader reader = cmd.ExecuteReader();
            List<User> list = new List<User>();
            while (reader.Read())
            {
                list.Add(new User()
                {
                    username = Convert.ToString(reader[1]),
                    email=Convert.ToString(reader[2]),
                });
            }
            return list;
        }

        public string removeUser(string value)
        {
            if (value==null)
            {
                return string.Format("Lo sentimos pero ha ocurrido un error");

            }
            else
            {
                SqlConnection sqlConnection = new SqlConnection("Data Source=DESKTOP-J7EBE14\\SQLEXPRESS;Initial Catalog=soap1;Integrated Security=True");
                sqlConnection.Open();
                string query = "delete from users where email='"+value+"'";
                SqlCommand cmd = new SqlCommand(query, sqlConnection);
                cmd.ExecuteNonQuery();
                return string.Format("Usuario eliminado con exito");

            }
        }

        public string updateUser(User user)
        {
            if(user.email.Length<3 || user.username.Length < 3)
            {
                return string.Format("Todos los campos son obligatorios");

            }
            else
            {
                SqlConnection sqlConnection = new SqlConnection("Data Source=DESKTOP-J7EBE14\\SQLEXPRESS;Initial Catalog=soap1;Integrated Security=True");
                sqlConnection.Open();
                string query = "update users set username='" + user.username + "' where email='" + user.email + "'";
                SqlCommand cmd = new SqlCommand(query, sqlConnection);
                cmd.ExecuteNonQuery();
                return string.Format("Usuario actualizado con exito");

            }

        }
    }
}
