package test;

import com.lvguyuan.pojo.TbBrand;
import com.lvguyuan.sellergoods.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-dao.xml"})
public class BrandTest {

    @Autowired
    private BrandService brandService;

    @Test
    public void brandTest(){
        List<TbBrand> list = brandService.findAll();
        for(TbBrand tbBrand:list){
            System.out.println(tbBrand.toString());
        }
    }




}
