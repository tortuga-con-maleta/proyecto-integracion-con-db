using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using UI_CRM.ESB_WS;
namespace UI_CRM
{
    public partial class CrudPromocion : System.Web.UI.Page
    {
         
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void fvPerfilCliente_ItemInserted(object sender, FormViewInsertedEventArgs e)
        {
            gvPerfilCliente.DataBind();
        }

        protected void btn_getVisitas_Click(object sender, EventArgs e)
        {
            ESBWSSoapClient esbWSSoapClient = new ESBWSSoapClient();
            ArrayOfString visitas = esbWSSoapClient.getVisitas();
            string mensaje = String.Empty;
            foreach (string fecha in visitas)
            {
                mensaje = mensaje + "\n" + fecha;
            }
            lbl_mensaje.Text = mensaje;
            System.Console.WriteLine("getvisitasfin");
        }

        protected void btn_getVisitasPorIdCliente_Click(object sender, EventArgs e)
        {
            int idCliente = int.Parse(txt_idCliente.Text);
            ESBWSSoapClient esbWSSoapClient = new ESBWSSoapClient();
            ArrayOfString respuesta = esbWSSoapClient.getVisitasPorIdCliente(idCliente);
            string[] visitas = respuesta.ToArray();
            string mensaje = String.Empty;
            foreach (string fecha in visitas)
            {
                mensaje = mensaje + "\n" + fecha;
            }
            lbl_mensaje.Text = mensaje;
            System.Console.WriteLine("get visitas por id cliente fin");
        }

        protected void btn_insertarZona_Click(object sender, EventArgs e)
        {
            string nombreZona = txt_nombreZona.Text;
            ESBWSSoapClient esbWSSoapClient = new ESBWSSoapClient();
            bool insercionTuvoExito = esbWSSoapClient.insertarZona(nombreZona);
            string mensaje = String.Empty;
            if (insercionTuvoExito)
            {
                mensaje = "Inserción de zona tuvo éxito";
            }
            else
            {
                mensaje = "Error en la inserción";
            }
            lbl_mensaje.Text = mensaje;
            System.Console.WriteLine("insertarZonaFin");
        }

        protected void btn_enviarMensajeCliente_Click(object sender, EventArgs e)
        {
            int idCliente = int.Parse(txt_idCliente2.Text);
            string mensajeCliente = txt_nombreZona.Text;
            ESBWSSoapClient esbWSSoapClient = new ESBWSSoapClient();
            bool insercionTuvoExito = esbWSSoapClient.enviarMensajeCliente(idCliente, mensajeCliente);
            string mensaje = String.Empty;
            if (insercionTuvoExito)
            {
                mensaje = "Mensaje tuvo éxito";
            }
            else
            {
                mensaje = "Mensaje no tuvo éxito";
            }
            lbl_mensaje.Text = mensaje;
            System.Console.WriteLine("enviarMensajeCliente fin");
        }

        


    }
}