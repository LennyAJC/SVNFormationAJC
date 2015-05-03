package test;

import java.sql.ResultSet;

import org.junit.Test;

import fr.cooking.data.dao.SQLUtils;
public class TestSQLUtils{
@Test //public static SQLUtils getInstance()
public void testGetInstance(){
SQLUtils e0 = SQLUtils.getInstance();
 
 
}
@Test //public ResultSet executeSQL(String,String)
public void testExecuteSQL(){
SQLUtils e0Obj = new SQLUtils();
ResultSet e0 = e0Obj.executeSQL("nb;'/","'c57r|=XVN_q-$B");
 
 
}
@Test
public void testSequence(){
SQLUtils e0Obj = new SQLUtils();
e0Obj.getInstance();
ResultSet e0 = e0Obj.executeSQL("ywx-d\\d&`xTxw-5","rtaY_AXj0+$rh7m");
 
 
SQLUtils e1 = SQLUtils.getInstance();
 
 
SQLUtils e2 = SQLUtils.getInstance();
 
 
SQLUtils e3 = SQLUtils.getInstance();
 
 
ResultSet e4 = e0Obj.executeSQL("p","RE~Y3O_.mWe^D\\h|OY");
 
 
ResultSet e5 = e0Obj.executeSQL("qOTu%%{#sCIkSR%","");
 
 
SQLUtils e6 = SQLUtils.getInstance();
 
 
SQLUtils e7 = SQLUtils.getInstance();
 
 
SQLUtils e8 = SQLUtils.getInstance();
 
 
ResultSet e9 = e0Obj.executeSQL("zn)$4&Uba3h&~^wU","3z%::+E2*3[");
 
 
}
}