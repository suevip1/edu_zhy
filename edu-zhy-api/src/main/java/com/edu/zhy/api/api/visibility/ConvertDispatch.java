package com.edu.zhy.api.api.visibility;


/**
 * @Auther: zishan
 * @Date: 2020-02-20
 */
public class ConvertDispatch {

    private static QuantityConverter quantityConverter = new QuantityConverter();
    private static MobileConverter mobileConverter = new MobileConverter();

    public static BaseConverter getConverter(Integer type) {
        ConverterTypeEnum converterTypeEnum = ConverterTypeEnum.getByType(type);
        switch (converterTypeEnum){
            case MOBILE_CONVERTER:
                return mobileConverter;
            case QUANTITY_CONVERTER:
                return quantityConverter;
        }
        return null;
    }

}
