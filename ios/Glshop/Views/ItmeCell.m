//
//  ItmeCell.m
//  Glshop
//
//  Created by River on 14-11-6.
//  Copyright (c) 2014年 appabc. All rights reserved.
//

#import "ItmeCell.h"

@implementation ItmeCell

- (instancetype)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    if (self) {
        self.backgroundColor = [UIColor whiteColor];
        
        _priceLabel = [UILabel labelWithTitle:@"89.9"];
        _priceLabel.textColor = [UIColor orangeColor];
        _priceLabel.font = [UIFont boldSystemFontOfSize:18.f];
        _priceLabel.textAlignment = NSTextAlignmentCenter;
        _priceLabel.frame = CGRectMake(0, 0, self.vwidth, 30);
        [self.contentView addSubview:_priceLabel];
        
        _productNameLabel = [UILabel labelWithTitle:@"粗沙"];
        _productNameLabel.font = [UIFont boldSystemFontOfSize:15.f];
        _productNameLabel.textAlignment = NSTextAlignmentCenter;
        _productNameLabel.frame = CGRectMake(0, _priceLabel.vbottom+3, self.vwidth, 20);
        [self.contentView addSubview:_productNameLabel];
        
        _subProductNameLabel = [UILabel labelWithTitle:@"特细砂(1.3-2.2)"];
        _subProductNameLabel.font = [UIFont systemFontOfSize:11.f];
        _subProductNameLabel.textAlignment = NSTextAlignmentCenter;
        _subProductNameLabel.textColor = [UIColor grayColor];
        _subProductNameLabel.frame = CGRectMake(0, _productNameLabel.vbottom+3, self.vwidth, 20);
        [self.contentView addSubview:_subProductNameLabel];
        
        UIImageView *sView = [[UIImageView alloc] initWithFrame:CGRectZero];
        UIImage *image = [[UIImage imageNamed:@"index_icon_envelopes"] resizableImageWithCapInsets:UIEdgeInsetsMake(5, 5, 5, 5) resizingMode:UIImageResizingModeTile];
        sView.image = image;
        self.selectedBackgroundView = sView;
        
    }
    return self;
}

- (void)setTodayModel:(ProductTodayModel *)todayModel {
    _todayModel = todayModel;
    
    _productNameLabel.text = todayModel.pname;
    _priceLabel.text = [todayModel.todayPrice stringValue];

}

@end
