//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace UI_CRM
{
    using System;
    using System.Collections.Generic;
    
    public partial class promocion
    {
        public int id_promocion { get; set; }
        public string nombre { get; set; }
        public string texto { get; set; }
        public Nullable<int> fk_perfil_cliente { get; set; }
        public Nullable<int> fk_departamento { get; set; }
    
        public virtual departamento departamento { get; set; }
        public virtual perfil_cliente perfil_cliente { get; set; }
    }
}
