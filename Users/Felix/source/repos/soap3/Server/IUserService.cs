using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace Server
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "IService1" en el código y en el archivo de configuración a la vez.
    [ServiceContract]
    public interface IUserService
    {

        [OperationContract]
        string addUser(User user);
               
        [OperationContract]
        string removeUser(string value);

        [OperationContract]
        List<User> getUsers();

        [OperationContract]
        string updateUser(User user);

        // TODO: agregue aquí sus operaciones de servicio
    }

    [DataContract]
    public class User
    {
        [DataMember]
        public string username { get; set; }

        [DataMember]
        public string email { get; set; }

      

    }
    
   
}
