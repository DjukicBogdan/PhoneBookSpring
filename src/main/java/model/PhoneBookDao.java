package model;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PhoneBookDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public int savePerson(PhoneBook p){
        String sql="insert into person(name, phoneNumber, email, adress) values('" + p.getName() + "','" + p.getPhoneNumber() + "','" + p.getEmail() + "','" + p.getAdress() + "')";
        return template.update(sql);
    }
    public int updatePerson(PhoneBook p){
        String sql="update person set name='"+p.getName()+"', phoneNumber='"+p.getPhoneNumber()+"',email='"+p.getEmail()+"',adress='"+p.getAdress()+ "' where id="+p.getId()+"";
        return template.update(sql);
    }
    public int deletePerson(int id){
        String sql="delete from person where id="+id+"";
        return template.update(sql);
    }
    public PhoneBook getPersonById(int id){
        String sql="select * from person where id=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<PhoneBook>(PhoneBook.class));
    }
    public List<PhoneBook> getPhoneBook(){
        return template.query("select * from person",new RowMapper<PhoneBook>(){
            public PhoneBook mapRow(ResultSet rs, int row) throws SQLException {
                PhoneBook p=new PhoneBook();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setPhoneNumber(rs.getString(3));
                p.setEmail(rs.getString(4));
                p.setAdress(rs.getString(5));

                return p;
            }
        });
    }
}
