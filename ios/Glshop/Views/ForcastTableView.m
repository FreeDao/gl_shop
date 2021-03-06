//
//  ForcastTableView.m
//  Glshop
//
//  Created by River on 14-11-24.
//  Copyright (c) 2014年 appabc. All rights reserved.
//

#import "ForcastTableView.h"
#import "WeekForcastTableViewCell.h"

static NSString *cellIdentify = @"forcastTableCell";

@implementation ForcastTableView

#pragma mark -
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.dataArray.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    WeekForcastTableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:cellIdentify];
    if (!cell) {
        cell = [[WeekForcastTableViewCell alloc] initWithStyle:UITableViewCellStyleDefault reuseIdentifier:cellIdentify];
    }
    cell.weekModel = self.dataArray[indexPath.row];
    
    if (indexPath.row%2 == 1) {
        cell.backgroundColor = RGB(247, 247, 247, 1);
    }else {
        cell.backgroundColor = [UIColor whiteColor];
    }
    
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    [tableView deselectRowAtIndexPath:indexPath animated:YES];
    if ([self.eventDelegate respondsToSelector:@selector(tableView:didSelectRowAtIndexPath:)]) {
        [self.eventDelegate tableView:self didSelectRowAtIndexPath:indexPath];
    }
}

@end
