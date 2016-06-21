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
    }
}