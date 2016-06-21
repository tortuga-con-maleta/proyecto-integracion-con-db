using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using ESB.BalizaWs;

namespace ESB
{
    /// <summary>
    /// Summary description for ESBWS
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class ESBWS : System.Web.Services.WebService
    {

        [WebMethod]
        public string[] getVisitas()
        {
            BalizaWSClient balizaWsClient = new BalizaWSClient();
            string [] mensaje = balizaWsClient.getFechaVisitas();
            return mensaje;
        }

        [WebMethod]
        public string[] getVisitasPorIdCliente(int idCliente)
        {
            BalizaWSClient balizaWsClient = new BalizaWSClient();
            string[] mensaje = balizaWsClient.getVisitasPorIdCliente(idCliente);
            return mensaje;
        }

        [WebMethod]
        public bool insertarZona(string nombreZona)
        {
            BalizaWSClient balizaWsClient = new BalizaWSClient();
            bool result = balizaWsClient.insertarZona(nombreZona);
            return result;
        }

        [WebMethod]
        public bool getVisitasPorIdCliente(int idCliente, string mensaje)
        {
            BalizaWSClient balizaWsClient = new BalizaWSClient();
            bool result = balizaWsClient.enviarMensajeCliente(idCliente, mensaje);
            return result;
        }
    }
}
