﻿//------------------------------------------------------------------------------
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
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    
    public partial class CRMEntities : DbContext
    {
        public CRMEntities()
            : base("name=CRMEntities")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public DbSet<cliente> cliente { get; set; }
        public DbSet<departamento> departamento { get; set; }
        public DbSet<perfil_cliente> perfil_cliente { get; set; }
        public DbSet<promocion> promocion { get; set; }
        public DbSet<sysdiagrams> sysdiagrams { get; set; }
    }
}
