<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CrudPromocion.aspx.cs" Inherits="UI_CRM.CrudPromocion" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:ScriptManager ID="ScriptManager1" runat="server">
        </asp:ScriptManager>
        <asp:EntityDataSource ID="perfilDS" runat="server" ConnectionString="name=CRMEntities1" DefaultContainerName="CRMEntities1" EnableDelete="True" EnableFlattening="False" EnableInsert="True" EnableUpdate="True" EntitySetName="perfil_cliente">
        </asp:EntityDataSource>
        <br />
        <h1>Bienvenido!</h1>
        <asp:UpdatePanel ID="UpdatePanel1" runat="server">
            <ContentTemplate>
                <asp:GridView ID="gvPerfilCliente" runat="server" AutoGenerateColumns="False" DataKeyNames="id_perfil_cliente" DataSourceID="perfilDS">
                    <Columns>
                        <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                        <asp:BoundField DataField="nombre" HeaderText="nombre" SortExpression="nombre" />
                    </Columns>
                </asp:GridView>
                <br />
                <asp:FormView ID="fvPerfilCliente" runat="server" DataKeyNames="id_perfil_cliente" DataSourceID="perfilDS" DefaultMode="Insert" OnItemInserted="fvPerfilCliente_ItemInserted">
                    <EditItemTemplate>
                        id_perfil_cliente:
                        <asp:Label ID="id_perfil_clienteLabel1" runat="server" Text='<%# Eval("id_perfil_cliente") %>' />
                        <br />
                        nombre:
                        <asp:TextBox ID="nombreTextBox" runat="server" Text='<%# Bind("nombre") %>' />
                        <br />
                        cliente:
                        <asp:TextBox ID="clienteTextBox" runat="server" Text='<%# Bind("cliente") %>' />
                        <br />
                        promocion:
                        <asp:TextBox ID="promocionTextBox" runat="server" Text='<%# Bind("promocion") %>' />
                        <br />
                        <asp:LinkButton ID="UpdateButton" runat="server" CausesValidation="True" CommandName="Update" Text="Update" />
                        &nbsp;<asp:LinkButton ID="UpdateCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
                    </EditItemTemplate>
                    <InsertItemTemplate>
                        nombre:
                        <asp:TextBox ID="nombreTextBox" runat="server" Text='<%# Bind("nombre") %>' />
                        <br />
                        <asp:LinkButton ID="InsertButton" runat="server" CausesValidation="True" CommandName="Insert" Text="Insert" />
                        &nbsp;<asp:LinkButton ID="InsertCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
                    </InsertItemTemplate>
                    <ItemTemplate>
                        nombre:
                        <asp:Label ID="nombreLabel" runat="server" Text='<%# Bind("nombre") %>' />
                        <br />
                        <asp:LinkButton ID="EditButton" runat="server" CausesValidation="False" CommandName="Edit" Text="Edit" />
                        &nbsp;<asp:LinkButton ID="DeleteButton" runat="server" CausesValidation="False" CommandName="Delete" Text="Delete" />
                        &nbsp;<asp:LinkButton ID="NewButton" runat="server" CausesValidation="False" CommandName="New" Text="New" />
                    </ItemTemplate>
                </asp:FormView>
            </ContentTemplate>
        </asp:UpdatePanel>
        <br />
    </div>
    </form>
</body>
</html>
